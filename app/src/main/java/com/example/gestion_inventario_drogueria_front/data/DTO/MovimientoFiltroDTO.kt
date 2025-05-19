package com.example.gestion_inventario_drogueria_front.data.DTO

import com.example.gestion_inventario_drogueria_front.data.models.TipoMovimiento
import java.time.LocalDate

data class MovimientoFiltroDTO (
    val fechaDesde: String? = null,
    val fechaHasta: String? = null,
    val fechaExacta: String? = null,
    val tipoMovimiento: String? = null,
    val codigoProducto: String? = null
)