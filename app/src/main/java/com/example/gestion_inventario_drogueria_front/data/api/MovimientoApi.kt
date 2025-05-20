package com.example.gestion_inventario_drogueria_front.data.api

import com.example.gestion_inventario_drogueria_front.data.DTO.DTOMovimientoRequest
import com.example.gestion_inventario_drogueria_front.data.DTO.MovimientoFiltroDTO
import com.example.gestion_inventario_drogueria_front.data.DTO.MovimientoReporteDTO
import com.example.gestion_inventario_drogueria_front.data.DTO.ResumenMovimientoInventarioDTO
import com.example.gestion_inventario_drogueria_front.data.models.Page
import com.example.gestion_inventario_drogueria_front.data.models.MovimientoInventario
import com.example.gestion_inventario_drogueria_front.data.models.Producto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface MovimientoApi {
    // Listar todos
    @GET("movimientos/paginar/{pagina}/fecha")
    suspend fun obtenerMovimientos(@Path("pagina") pagina: Int): Page<MovimientoInventario>

    // Generar reporte
    @POST("movimientos/reporte")
    suspend fun obtenerReporte(@Body filtro: MovimientoFiltroDTO): List<MovimientoReporteDTO>

    // Resumen reporte
    @POST("movimientos/resumen")
    suspend fun obtenerResumen(@Body filtro: MovimientoFiltroDTO): ResumenMovimientoInventarioDTO

    // Crear
    @POST("movimientos/crear")
    suspend fun crearMovimiento(@Body request: DTOMovimientoRequest): MovimientoInventario
}