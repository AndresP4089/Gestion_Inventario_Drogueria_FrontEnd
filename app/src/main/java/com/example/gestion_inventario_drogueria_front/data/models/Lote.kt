package com.example.gestion_inventario_drogueria_front.data.models

data class Lote(
    val id: Long,
    val producto: Producto,
    val proveedor: Proveedor,
    val numeroLote: String,
    val fechaIngreso: String,       // O LocalDate si lo parseas
    val fechaVencimiento: String,   // O LocalDate si lo parseas
    val estado: EstadoLote
)

enum class EstadoLote {
    ACTIVO,
    INACTIVO
}
