package com.example.gestion_inventario_drogueria_front.data.DTO

import com.example.gestion_inventario_drogueria_front.data.models.TipoMovimiento

data class DTOMovimientoRequest (
    val codigoProducto: String,
    val cantidad: Int,
    val tipo: String,
    val precioCompraVenta: Double,
    val motivo: String? = null,
    val observaciones: String? = null,
    // Se requiere en caso de entrada, para productos controlados por lote
    val lote: DTOLoteRequest? = null, // ya establecido
    // Se requiere en caso de salida, para productos controlados por lote
    val numeroLote: String? = null
)

data class DTOLoteRequest (
    val numeroLote: String,
    val fechaVencimiento: String,
    val codigoProducto: String,
    val nitProveedor: String
)