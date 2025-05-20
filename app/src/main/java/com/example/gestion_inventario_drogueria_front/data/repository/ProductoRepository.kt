package com.example.gestion_inventario_drogueria_front.data.repository

import com.example.gestion_inventario_drogueria_front.data.api.ProductoApi
import com.example.gestion_inventario_drogueria_front.data.api.RetrofitInstance
import com.example.gestion_inventario_drogueria_front.data.models.Page
import com.example.gestion_inventario_drogueria_front.data.models.Producto

/* Es la clase que actúa como puente entre el ViewModel y el API.
🔹 Aquí puedes aplicar lógica adicional si necesitas transformar datos.
🔹 También es el lugar para manejar errores o combinar datos de varias fuentes.
 */
class ProductoRepository {
    private val retrofitService = RetrofitInstance.retrofit.create(ProductoApi::class.java)

    suspend fun obtenerProductos(pagina: Int): Page<Producto> {
        return retrofitService.obtenerProductos(pagina)
    }

    suspend fun obtenerPorCodigo(codigo: String): Producto {
        // Si no trae codigo
        if (codigo == null || codigo.isBlank()) {
            throw RuntimeException("Debe proporcionar el código.")
        }
        return retrofitService.obtenerPorCodigo(codigo)
    }

    suspend fun obtenerPorNombre(pagina: Int, nombre: String): Page<Producto> {
        return retrofitService.obtenerPorNombre(pagina, nombre)
    }

    suspend fun crearProducto(producto: Producto): Producto {
        return retrofitService.crearProducto(producto)
    }
}