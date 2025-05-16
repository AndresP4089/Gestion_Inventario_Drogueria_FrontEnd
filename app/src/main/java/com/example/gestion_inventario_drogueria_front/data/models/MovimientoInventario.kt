package com.example.gestion_inventario_drogueria_front.data.models

import java.time.LocalDate

data class MovimientoInventario(
    val id: Long? = null,
    val productoId: Long,
    val loteId: Long? = null,
    val cantidad: Int,
    val precioCompraVenta: Double,
    val fecha: LocalDate,
    val motivo: String? = null,
    val observaciones: String? = null,
    val tipo: TipoMovimiento
)

enum class TipoMovimiento {
    ENTRADA,
    SALIDA
}
