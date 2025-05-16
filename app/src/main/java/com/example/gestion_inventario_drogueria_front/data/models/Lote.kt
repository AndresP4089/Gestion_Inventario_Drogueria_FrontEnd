package com.example.gestion_inventario_drogueria_front.data.models

import java.time.LocalDate

data class Lote(
    val id: Long? = null,
    val productoId: Long,
    val proveedorId: Long,
    val numeroLote: String,
    val fechaIngreso: LocalDate,
    val fechaVencimiento: LocalDate,
    val estado: EstadoLote = EstadoLote.ACTIVO
)

enum class EstadoLote {
    ACTIVO,
    INACTIVO
}
