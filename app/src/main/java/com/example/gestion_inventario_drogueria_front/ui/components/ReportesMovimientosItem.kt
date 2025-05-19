package com.example.gestion_inventario_drogueria_front.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.gestion_inventario_drogueria_front.data.DTO.MovimientoReporteDTO
import com.example.gestion_inventario_drogueria_front.data.models.MovimientoInventario


// Componente reutilizable de productos
@Composable
fun ReportesMovimientosItem(reporte: MovimientoReporteDTO) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
            .padding(8.dp)
    ) {
        Text("Movimiento N°: ${reporte.id}", style = MaterialTheme.typography.bodyLarge)

        Spacer(modifier = Modifier.height(4.dp))
        Text("Producto: ${reporte.codigoProducto} - ${reporte.nombreProducto}")

        Spacer(modifier = Modifier.height(4.dp))
        if (reporte.numeroLote != null) {
            Text("Lote: ${reporte.numeroLote}")
            reporte.fechaVencimientoLote?.let {
                Text("Vence: $it")
            }
        } else {
            Text("Lote: Sin lote")
        }

        Spacer(modifier = Modifier.height(4.dp))
        Text("Cantidad: ${reporte.cantidad}")
        Text("Precio: \$${reporte.precioCompraVenta}")
        Text("Fecha: ${reporte.fecha}")

        Spacer(modifier = Modifier.height(4.dp))
        Text("Tipo: ${reporte.tipo}")

        if (!reporte.motivo.isNullOrBlank()) {
            Text("Motivo: ${reporte.motivo}")
        } else {
            Text("Motivo: Sin motivo")
        }

        if (!reporte.observaciones.isNullOrBlank()) {
            Text("Observaciones: ${reporte.observaciones}")
        } else {
            Text("Observaciones: Sin observaciones")
        }

        reporte.nombreProveedor?.let {
            Spacer(modifier = Modifier.height(4.dp))
            Text("Proveedor: $it")
        }
    }
}

