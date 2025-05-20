package com.example.gestion_inventario_drogueria_front.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gestion_inventario_drogueria_front.data.models.Proveedor
import com.example.gestion_inventario_drogueria_front.data.repository.ProveedorRepository
import kotlinx.coroutines.launch

class ProveedorViewModel: ViewModel()  {
    private val repository = ProveedorRepository()

    // Listar proveedores
    private val _proveedores = MutableLiveData<List<Proveedor>>()
    val proveedores: LiveData<List<Proveedor>> = _proveedores

    private val _proveedorBuscado = MutableLiveData<Proveedor?>()
    val proveedorBuscado: LiveData<Proveedor?> = _proveedorBuscado

    // Paginacion
    private var paginaActual = 0
    private var ultimaPagina: Boolean = false
    private var totalPaginas: Int = 1
    private var terminoBusqueda: String? = null
    val paginacion = PaginacionController(
        cargarPagina = { offset ->
            val nuevaPagina = paginaActual + offset
            if (terminoBusqueda != null) {
                obtenerPorNombre(nuevaPagina, terminoBusqueda!!)
            } else {
                cargarProveedores(nuevaPagina)
            }
        },
        puedeAvanzar = { !ultimaPagina },
        puedeRetroceder = { paginaActual > 0 }
    )

    // Obtener todos
    fun cargarProveedores(pagina: Int = paginaActual) {
        terminoBusqueda = null
        _proveedores.value = emptyList()
        viewModelScope.launch {
            try {
                val paginaData = repository.obtenerProveedores(pagina)
                _proveedores.value = paginaData.content
                paginaActual = paginaData.number
                ultimaPagina = paginaData.last
                totalPaginas = paginaData.totalPages
            } catch (e: Exception) {
                Log.e("ProveedorViewModel", "Error cargando productos", e)
            }
        }
    }

    // Obtener por nit
    fun obtenerPorNit(nit: String) {
        viewModelScope.launch {
            try {
                val proveedor = repository.obtenerProveedoresPorNit(nit)
                _proveedorBuscado.value = proveedor
            } catch (e: Exception) {
                Log.e("ProveedorViewModel", "Error buscando proveedor", e)
            }
        }
    }

    // Obtener por nombre
    fun obtenerPorNombre(pagina: Int, nombre: String) {
        viewModelScope.launch {
            try {
                val paginaData = repository.obtenerProveedoresPorNombre(pagina, nombre)
                _proveedores.value = paginaData.content
                paginaActual = paginaData.number
                ultimaPagina = paginaData.last
                totalPaginas = paginaData.totalPages
                terminoBusqueda = nombre
            } catch (e: Exception) {
                Log.e("ProveedorViewModel", "Error buscando proveedor", e)
            }
        }
    }

    fun iniciarBusqueda(nombre: String) {
        terminoBusqueda = nombre
        _proveedores.value = emptyList()
        obtenerPorNombre(0, nombre)
    }

    fun limpiarBusqueda() {
        terminoBusqueda = null
        _proveedores.value = emptyList()
        paginaActual = 0
        ultimaPagina = false
        totalPaginas = 1
    }

    fun crearProveedor(proveedor: Proveedor) {
        viewModelScope.launch {
            try {
                repository.crearProveedor(proveedor)
                // Si quieres mostrar un log en consola o algo simple:
                Log.d("ProveedorViewModel", "Proveedor creado correctamente")
            } catch (e: Exception) {
                Log.e("ProveedorViewModel", "Error al crear proveedor: ${e.message}")
            }
        }
    }

    fun getPaginaActual(): Int = paginaActual + 1
    fun getTotalPaginas(): Int = totalPaginas
}