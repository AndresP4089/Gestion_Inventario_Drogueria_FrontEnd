package com.example.gestion_inventario_drogueria_front.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gestion_inventario_drogueria_front.data.DTO.DTOMovimientoRequest
import com.example.gestion_inventario_drogueria_front.data.DTO.MovimientoFiltroDTO
import com.example.gestion_inventario_drogueria_front.data.DTO.MovimientoReporteDTO
import com.example.gestion_inventario_drogueria_front.data.DTO.ResumenMovimientoInventarioDTO
import com.example.gestion_inventario_drogueria_front.data.models.MovimientoInventario
import com.example.gestion_inventario_drogueria_front.data.models.Producto
import com.example.gestion_inventario_drogueria_front.data.repository.MovimientoRepository
import com.example.gestion_inventario_drogueria_front.data.repository.ProductoRepository
import kotlinx.coroutines.launch

class MovimientoViewModel: ViewModel() {
    private val repository = MovimientoRepository()
    private val productoRepository = ProductoRepository()

    // Lista movimientos
    private val _movimientos = MutableLiveData<List<MovimientoInventario>>()
    val movimientos: LiveData<List<MovimientoInventario>> = _movimientos

    // Lista reportes
    private val _reportes = MutableLiveData<List<MovimientoReporteDTO>>()
    val reportes: LiveData<List<MovimientoReporteDTO>> = _reportes

    // Resumen reporte
    private val _resumenReporte = MutableLiveData<ResumenMovimientoInventarioDTO>()
    val resumenReporte: LiveData<ResumenMovimientoInventarioDTO> = _resumenReporte

    // Paginacion
    private var paginaActual = 0
    private var ultimaPagina: Boolean = false
    private var totalPaginas: Int = 1
    private var terminoBusqueda: String? = null
    val paginacion = PaginacionController(
        cargarPagina = { offset ->
            val nuevaPagina = paginaActual + offset
            cargarMovimientos(nuevaPagina)
        },
        puedeAvanzar = { !ultimaPagina },
        puedeRetroceder = { paginaActual > 0 }
    )

    fun cargarMovimientos(pagina: Int) {
        terminoBusqueda = null
        _movimientos.value = emptyList()
        viewModelScope.launch {
            try {
                val paginaData = repository.obtenerMovimientos(pagina)
                _movimientos.value = paginaData.content
                paginaActual = paginaData.number
                ultimaPagina = paginaData.last
                totalPaginas = paginaData.totalPages
            } catch (e: Exception) {
                Log.e("MovimientosViewModel", "Error cargando movimientos", e)
            }
        }
    }

    fun obtenerResumenReporte(filtro: MovimientoFiltroDTO) {
        viewModelScope.launch {
            try {
                val resumen = repository.obtenerResumen(filtro)
                _resumenReporte.value = resumen
            } catch (e: Exception) {
                Log.e("MovimientosViewModel", "Error cargando movimientos", e)
            }
        }
    }

    fun cargarReportes(filtro: MovimientoFiltroDTO) {
        terminoBusqueda = null
        _reportes.value = emptyList()
        viewModelScope.launch {
            try {
                val data = repository.obtenerReporte(filtro)
                _reportes.value = data
            } catch (e: Exception) {
                Log.e("MovimientosViewModel", "Error cargando movimientos", e)
            }
        }
    }

    fun crearMovimiento(request: DTOMovimientoRequest) {
        viewModelScope.launch {
            try {
                repository.crearMovimiento(request)
                // Si quieres mostrar un log en consola o algo simple:
                Log.d("MovimientoViewModel", "Movimiento creado correctamente")
            } catch (e: Exception) {
                Log.e("MovimientoViewModel", "Error al crear movimiento: ${e.message}")
            }
        }
    }

    fun verificarProducto(codigo: String, callback: (Boolean) -> Unit) {
        viewModelScope.launch {
            try {
                val producto = productoRepository.obtenerPorCodigo(codigo)
                callback(producto.controladoPorLote)
            } catch (e: Exception) {
                callback(false)
            }
        }
    }


    fun getPaginaActual(): Int = paginaActual + 1
    fun getTotalPaginas(): Int = totalPaginas
}