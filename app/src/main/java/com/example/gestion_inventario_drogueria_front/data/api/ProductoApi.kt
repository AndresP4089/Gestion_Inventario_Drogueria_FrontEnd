package com.example.gestion_inventario_drogueria_front.data.api

import com.example.gestion_inventario_drogueria_front.data.models.Page
import com.example.gestion_inventario_drogueria_front.data.models.Producto
import retrofit2.http.GET
import retrofit2.http.Path

/* Es una interfaz de Retrofit que define las rutas HTTP (endpoints) que la app puede llamar.
🔹 Su rol es mapear endpoints a funciones Kotlin.
🔹 No contiene lógica, solo dice cómo llamar al backend.
 */
interface ProductoApi {
    // Traer todos
    @GET("productos/paginar/{pagina}")
    suspend fun obtenerProductos(@Path("pagina") pagina: Int): Page<Producto>

    // Buscar por código
    @GET("productos/buscar/{codigo}")
    suspend fun obtenerPorCodigo(@Path("codigo") codigo: String): Producto
}
