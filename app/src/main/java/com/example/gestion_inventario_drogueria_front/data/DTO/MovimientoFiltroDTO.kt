package com.example.gestion_inventario_drogueria_front.data.DTO

import com.example.gestion_inventario_drogueria_front.data.models.TipoMovimiento
import java.time.LocalDate

data class MovimientoFiltroDTO (
    val fechaDesde: LocalDate,
    val fechaHasta: LocalDate,
    val fechaExacta: LocalDate,
    val tipoMovimiento: TipoMovimiento,
    val codigoProducto: String
)