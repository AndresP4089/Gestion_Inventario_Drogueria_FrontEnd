package com.example.gestion_inventario_drogueria_front.data.api

import com.example.gestion_inventario_drogueria_front.data.models.Page
import com.example.gestion_inventario_drogueria_front.data.models.Proveedor
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ProveedorApi {
    // Todos
    @GET("proveedores/paginar/{pagina}")
    suspend fun obtenerProveedores(@Path("pagina") pagina: Int): Page<Proveedor>

    // Por nit
    @GET("proveedores/buscar/{nit}")
    suspend fun obtenerProveedoresPorNit(@Path("nit") nit: String): Proveedor

    // Por nombre
    @GET("proveedores/paginar/{pagina}/nombre/{nombre}")
    suspend fun obtenerProveedoresPorNombre(@Path("pagina") pagina: Int, @Path("nombre") nombre: String): Page<Proveedor>

    // Crear
    @POST("proveedores/crear")
    suspend fun crearProveedor(@Body proveedor: Proveedor): Proveedor
}