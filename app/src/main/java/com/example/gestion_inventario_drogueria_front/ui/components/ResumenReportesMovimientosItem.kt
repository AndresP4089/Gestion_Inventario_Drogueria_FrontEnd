package com.example.gestion_inventario_drogueria_front.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.gestion_inventario_drogueria_front.data.DTO.MovimientoFiltroDTO
import com.example.gestion_inventario_drogueria_front.data.DTO.MovimientoReporteDTO
import com.example.gestion_inventario_drogueria_front.data.DTO.ResumenMovimientoInventarioDTO
import com.example.gestion_inventario_drogueria_front.data.models.MovimientoInventario


// Componente reutilizable de productos
@Composable
fun ResumenReportesMovimientosItem(resumen: ResumenMovimientoInventarioDTO) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
            .padding(8.dp)
    ) {
        Text("Resumen", style = MaterialTheme.typography.bodyLarge)

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
                .padding(8.dp)
        ) {
            Text("Resumen de movimientos:")
            Text("Total: ${resumen.totalesMovimientos.totalMovimientos}")
            Text("Total Neto: ${resumen.totalesMovimientos.totalNeto}")
            Text("Total Entradas: ${resumen.totalesMovimientos.totalEntradas}")
            Text("Total Salidas: ${resumen.totalesMovimientos.totalSalidas}")
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
                .padding(8.dp)
        ) {
            Text("Resumen de valores:")
            Text("Valor Total: \$${resumen.totalesValores.valorTotal}")
            Text("Valor Total Neto: \$${resumen.totalesValores.valorNeto}")
            Text("Valor Total Entradas: \$${resumen.totalesValores.valorTotalEntradas}")
            Text("Valor Total Salidas: \$${resumen.totalesValores.valorTotalSalidas}")
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
                .padding(8.dp)
        ) {

            Text("Movimientos:")

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(max = 200.dp) // Puedes ajustar este valor según el diseño
            ) {
                items(resumen.movimientos) { reporte ->
                    ReportesMovimientosItem(reporte)
                }
            }
        }
    }
}


