package com.example.gestion_inventario_drogueria_front.data.repository

import com.example.gestion_inventario_drogueria_front.data.api.ProductoApi
import com.example.gestion_inventario_drogueria_front.data.api.RetrofitInstance
import com.example.gestion_inventario_drogueria_front.data.models.PaginaDeProductos

class ProductoRepository {
    private val retrofitService = RetrofitInstance.retrofit.create(ProductoApi::class.java)

    suspend fun obtenerProductos(): PaginaDeProductos {
        return retrofitService.obtenerProductos(pagina = 0)
    }
}