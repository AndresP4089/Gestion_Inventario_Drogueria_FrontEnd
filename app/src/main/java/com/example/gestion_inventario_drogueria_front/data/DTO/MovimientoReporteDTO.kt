package com.example.gestion_inventario_drogueria_front.data.DTO

import com.example.gestion_inventario_drogueria_front.data.models.TipoMovimiento
import java.time.LocalDate

data class MovimientoReporteDTO (

    // Datos de movimiento
    val id: Long,
    val tipo: TipoMovimiento, // ENTRADA o SALIDA
    val cantidad: Int,
    val precioCompraVenta: Double,
    val fecha: String,
    val motivo: String? = null,
    val observaciones: String? = null,

    // Datos del producto
    val codigoProducto: String,
    val nombreProducto: String,

    // Datos del lote (si aplica)
    val numeroLote: String? = null,
    val fechaVencimientoLote: String? = null,

    // Datos del proveedor
    val nombreProveedor: String? = null
)
