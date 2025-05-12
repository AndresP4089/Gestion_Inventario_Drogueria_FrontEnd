package com.example.gestion_inventario_drogueria_front.ui.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.example.gestion_inventario_drogueria_front.data.models.Producto
import com.example.gestion_inventario_drogueria_front.data.repository.ProductoRepository
import kotlinx.coroutines.launch

class ProductoViewModel : ViewModel() {
    private val repository = ProductoRepository()

    private val _productos = MutableLiveData<List<Producto>>()
    val productos: LiveData<List<Producto>> = _productos

    fun cargarProductos() {
        viewModelScope.launch {
            try {
                val pagina = repository.obtenerProductos()  // <--- obtenemos la página completa
                _productos.value = pagina.content            // <--- usamos solo el contenido
            } catch (e: Exception) {
                Log.e("ProductoViewModel", "Error cargando productos", e)
            }
        }
    }
}
