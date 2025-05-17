package com.example.gestion_inventario_drogueria_front.data.repository

import com.example.gestion_inventario_drogueria_front.data.api.LoteApi
import com.example.gestion_inventario_drogueria_front.data.api.RetrofitInstance
import com.example.gestion_inventario_drogueria_front.data.models.Page
import com.example.gestion_inventario_drogueria_front.data.models.Lote

class LoteRepository {

    private val retrofitService: LoteApi = RetrofitInstance.retrofit.create(LoteApi::class.java)

    suspend fun obtenerLoteFechaIngreso(pagina: Int): Page<Lote> {
        return retrofitService.obtenerLoteFechaIngreso(pagina)
    }

    suspend fun obtenerLoteFechaVencimiento(pagina: Int): Page<Lote> {
        return retrofitService.obtenerLoteFechaVencimiento(pagina)
    }

    suspend fun obtenerPorNumeroLote(numLote: String): Lote {
        return retrofitService.obtenerPorNumeroLote(numLote)
    }
}
