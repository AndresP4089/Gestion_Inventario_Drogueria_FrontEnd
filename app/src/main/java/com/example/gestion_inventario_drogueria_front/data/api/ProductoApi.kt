package com.example.gestion_inventario_drogueria_front.data.api

import com.example.gestion_inventario_drogueria_front.data.models.PaginaDeProductos
import com.example.gestion_inventario_drogueria_front.data.models.Producto
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductoApi {
    // Traer todos
    @GET("productos/paginar/{pagina}")
    suspend fun obtenerProductos(@Path("pagina") pagina: Int): PaginaDeProductos
}