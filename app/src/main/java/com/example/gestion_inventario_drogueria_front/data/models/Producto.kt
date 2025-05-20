package com.example.gestion_inventario_drogueria_front.data.models

// Corregir los datos
data class Producto(
    val id: Long? = null,
    val nombre: String,
    val codigo: String,
    val descripcion: String? = null,
    val precioUnitario: Double,
    val laboratorio: String? = null,
    val principioActivo: String? = null,
    val presentacion: String,
    val unidadMedida: String,
    val stockMinimo: Int = 0,
    val estado: EstadoProducto = EstadoProducto.ACTIVO,
    val controladoPorLote: Boolean
)

enum class EstadoProducto {
    ACTIVO,
    INACTIVO
}
