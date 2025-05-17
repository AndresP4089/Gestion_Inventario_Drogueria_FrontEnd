package com.example.gestion_inventario_drogueria_front.data.DTO

data class ResumenMovimientoInventarioDTO (
    val movimientos: List<MovimientoReporteDTO>,
    val totalesMovimientos: TotalesMovimientoDTO,
    val totalesValores: TotalesValoresDTO
)

data class TotalesMovimientoDTO (
    // Movimientos
    val totalEntradas: Int,
    val totalSalidas: Int,
    val totalMovimientos: Int,
    val totalNeto: Int
)

data class TotalesValoresDTO (
    // Valores
    val valorTotalEntradas: Double,
    val valorTotalSalidas: Double,
    val valorTotal: Double,
    val valorNeto: Double
)