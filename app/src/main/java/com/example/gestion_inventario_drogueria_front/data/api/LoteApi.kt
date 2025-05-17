package com.example.gestion_inventario_drogueria_front.data.api

import com.example.gestion_inventario_drogueria_front.data.models.Lote
import com.example.gestion_inventario_drogueria_front.data.models.Page
import retrofit2.http.GET
import retrofit2.http.Path

interface LoteApi {
    // Traer todos fecha ingreso
    @GET("lotes/paginar/fecha-ingreso/{pagina}")
    suspend fun obtenerLoteFechaIngreso(@Path("pagina") pagina: Int): Page<Lote>

    // Buscar por numero lote
    @GET("lotes/buscar/{numLote}")
    suspend fun obtenerPorNumeroLote(@Path("numLote") numLote: String): Lote

    // Traer todos fecha vencimiento
    @GET("lotes/paginar/fecha-vencimiento/{pagina}")
    suspend fun obtenerLoteFechaVencimiento(@Path("pagina") pagina: Int): Page<Lote>
}