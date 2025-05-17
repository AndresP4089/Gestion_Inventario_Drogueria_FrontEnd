package com.example.gestion_inventario_drogueria_front.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gestion_inventario_drogueria_front.data.models.Lote
import com.example.gestion_inventario_drogueria_front.data.repository.LoteRepository
import kotlinx.coroutines.launch

class LoteViewModel: ViewModel() {
    private val repository = LoteRepository()

    // Listas de lotes
    private val _lotes = MutableLiveData<List<Lote>>()
    val lotes: LiveData<List<Lote>> = _lotes

    // Buscar un lote
    private val _loteBuscado = MutableLiveData<Lote?>()
    val loteBuscado: LiveData<Lote?> = _loteBuscado

    // Paginacion
    private var paginaActual = 0
    private var ultimaPagina: Boolean = false
    private var totalPaginas: Int = 1
    private var terminoBusqueda: String? = null
    val paginacion = PaginacionController(
        cargarPagina = { offset ->
            val nuevaPagina = paginaActual + offset
            cargarLotesFechaIngreso(nuevaPagina) // usa aquí la función que necesitas
        },
        puedeAvanzar = { !ultimaPagina },
        puedeRetroceder = { paginaActual > 0 }
    )

    fun cargarLotesFechaIngreso(pagina: Int) {
        terminoBusqueda = null
        _lotes.value = emptyList()
        viewModelScope.launch {
            try {
                val paginaData = repository.obtenerLoteFechaIngreso(pagina)
                _lotes.value = paginaData.content
                paginaActual = paginaData.number
                ultimaPagina = paginaData.last
                totalPaginas = paginaData.totalPages
            } catch (e: Exception) {
                Log.e("LoteViewModel", "Error cargando lote", e)
            }
        }
    }

    fun obtenerPorNumeroLote(numLote: String) {
        viewModelScope.launch {
            try {
                val lote = repository.obtenerPorNumeroLote(numLote)
                _loteBuscado.value = lote
            } catch (e: Exception) {
                Log.e("LoteViewModel", "Error buscando lote", e)
            }
        }
    }

    fun cargarLotesFechaVencimiento(pagina: Int) {
        terminoBusqueda = null
        _lotes.value = emptyList()
        viewModelScope.launch {
            try {
                val paginaData = repository.obtenerLoteFechaVencimiento(pagina)
                _lotes.value = paginaData.content
                paginaActual = paginaData.number
                ultimaPagina = paginaData.last
                totalPaginas = paginaData.totalPages
            } catch (e: Exception) {
                Log.e("LoteViewModel", "Error cargando lote", e)
            }
        }
    }

    fun getPaginaActual(): Int = paginaActual + 1
    fun getTotalPaginas(): Int = totalPaginas
}