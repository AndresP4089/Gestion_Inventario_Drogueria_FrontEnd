package com.example.gestion_inventario_drogueria_front.data.repository

import com.example.gestion_inventario_drogueria_front.data.DTO.DTOMovimientoRequest
import com.example.gestion_inventario_drogueria_front.data.DTO.MovimientoFiltroDTO
import com.example.gestion_inventario_drogueria_front.data.DTO.MovimientoReporteDTO
import com.example.gestion_inventario_drogueria_front.data.DTO.ResumenMovimientoInventarioDTO
import com.example.gestion_inventario_drogueria_front.data.api.LoteApi
import com.example.gestion_inventario_drogueria_front.data.api.MovimientoApi
import com.example.gestion_inventario_drogueria_front.data.api.RetrofitInstance
import com.example.gestion_inventario_drogueria_front.data.models.Page
import com.example.gestion_inventario_drogueria_front.data.models.Lote
import com.example.gestion_inventario_drogueria_front.data.models.MovimientoInventario
import com.example.gestion_inventario_drogueria_front.data.models.Producto

class MovimientoRepository {

    private val retrofitService: MovimientoApi = RetrofitInstance.retrofit.create(MovimientoApi::class.java)

    suspend fun obtenerMovimientos(pagina: Int): Page<MovimientoInventario> {
        return retrofitService.obtenerMovimientos(pagina)
    }

    suspend fun obtenerReporte(filtro: MovimientoFiltroDTO): List<MovimientoReporteDTO> {
        return retrofitService.obtenerReporte(filtro)
    }

    suspend fun obtenerResumen(filtro: MovimientoFiltroDTO): ResumenMovimientoInventarioDTO {
        return retrofitService.obtenerResumen(filtro)
    }

    suspend fun crearMovimiento(request: DTOMovimientoRequest): MovimientoInventario {
        return retrofitService.crearMovimiento(request)
    }
}
