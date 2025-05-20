package com.example.gestion_inventario_drogueria_front.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.gestion_inventario_drogueria_front.data.models.MovimientoInventario


// Componente reutilizable de productos
@Composable
fun MovimientoItem(movimiento: MovimientoInventario) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
            .padding(8.dp)
    ) {
        Text(text = "Movimiento numero: ${movimiento.id}", style = MaterialTheme.typography.bodyLarge)
        Text(text = "Cantidad: ${movimiento.cantidad}")
        Text(text = "Precio: \$${movimiento.precioCompraVenta}")
        Text(text = "Fecha: ${movimiento.cantidad}")
        if (movimiento.motivo != null) {
            Text(text = "Motivo: ${movimiento.motivo}")
        } else {
            Text(text = "Motivo: Sin motivo\n")
        }
        if (movimiento.observaciones != null) {
            Text(text = "Observaciones: ${movimiento.observaciones}")
        } else {
            Text(text = "Observaciones: Sin observaciones\n")
        }
        Text(text = "Tipó : ${movimiento.tipo}")
        if (movimiento.lote != null) {
            LoteItem(movimiento.lote)
        } else {
            ProductoItem(movimiento.producto)
        }
    }
}