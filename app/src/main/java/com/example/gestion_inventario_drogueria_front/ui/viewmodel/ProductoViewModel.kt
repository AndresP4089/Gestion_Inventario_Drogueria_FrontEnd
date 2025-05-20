package com.example.gestion_inventario_drogueria_front.ui.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.example.gestion_inventario_drogueria_front.data.models.*
import com.example.gestion_inventario_drogueria_front.data.repository.ProductoRepository
import kotlinx.coroutines.launch

/* Contiene la lógica de la interfaz (UI logic): gestiona el estado para que la pantalla sepa qué mostrar.
🔹 Usa LiveData para actualizar la vista automáticamente cuando haya datos.
🔹 viewModelScope.launch lanza una corrutina (función asincrónica).
 */
class ProductoViewModel : ViewModel() {
    private val repository = ProductoRepository()

    private val _productos = MutableLiveData<List<Producto>>()
    val productos: LiveData<List<Producto>> = _productos

    private val _productoBuscado = MutableLiveData<Producto?>()
    val productoBuscado: LiveData<Producto?> = _productoBuscado

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
                cargarProductos(nuevaPagina)
            }
        },
        puedeAvanzar = { !ultimaPagina },
        puedeRetroceder = { paginaActual > 0 }
    )

    fun cargarProductos(pagina: Int = paginaActual) {
        terminoBusqueda = null
        _productos.value = emptyList()
        viewModelScope.launch {
            try {
                val paginaData = repository.obtenerProductos(pagina)
                _productos.value = paginaData.content
                paginaActual = paginaData.number
                ultimaPagina = paginaData.last
                totalPaginas = paginaData.totalPages
            } catch (e: Exception) {
                Log.e("ProductoViewModel", "Error cargando productos", e)
            }
        }
    }

    fun obtenerPorCodigo(codigo: String) {
        viewModelScope.launch {
            try {
                val producto = repository.obtenerPorCodigo(codigo)
                _productoBuscado.value = producto
            } catch (e: Exception) {
                Log.e("ProductoViewModel", "Error buscando producto", e)
            }
        }
    }

    fun obtenerPorNombre(pagina: Int, nombre: String) {
        viewModelScope.launch {
            try {
                val paginaData = repository.obtenerPorNombre(pagina, nombre)
                _productos.value = paginaData.content
                paginaActual = paginaData.number
                ultimaPagina = paginaData.last
                totalPaginas = paginaData.totalPages
                terminoBusqueda = nombre
            } catch (e: Exception) {
                Log.e("ProductoViewModel", "Error buscando producto", e)
            }
        }
    }

    fun iniciarBusqueda(nombre: String) {
        terminoBusqueda = nombre
        _productos.value = emptyList()
        obtenerPorNombre(0, nombre)
    }

    fun limpiarBusqueda() {
        terminoBusqueda = null
        _productos.value = emptyList()
        paginaActual = 0
        ultimaPagina = false
        totalPaginas = 1
    }

    fun crearProducto(producto: Producto) {
        viewModelScope.launch {
            try {
                repository.crearProducto(producto)
                // Si quieres mostrar un log en consola o algo simple:
                Log.d("ProductoViewModel", "Producto creado correctamente")
            } catch (e: Exception) {
                Log.e("ProductoViewModel", "Error al crear producto: ${e.message}")
            }
        }
    }

    fun getPaginaActual(): Int = paginaActual + 1
    fun getTotalPaginas(): Int = totalPaginas
}



