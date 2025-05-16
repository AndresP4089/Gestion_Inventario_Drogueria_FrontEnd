package com.example.gestion_inventario_drogueria_front.data.models

data class Proveedor(
    val id: Long? = null,
    val nombre: String,
    val nit: String? = null,
    val direccion: String? = null,
    val telefono: String,
    val email: String,
    val estado: EstadoProveedor = EstadoProveedor.ACTIVO
)

enum class EstadoProveedor {
    ACTIVO,
    INACTIVO
}

