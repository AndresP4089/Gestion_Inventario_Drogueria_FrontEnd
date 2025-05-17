package com.example.gestion_inventario_drogueria_front.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.gestion_inventario_drogueria_front.data.models.MovimientoInventario


// Componente reutilizable de productos
@Composable
fun MovimientoItem(movimiento: MovimientoInventario) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)) {
        Text(text = "Movimiento numero: ${movimiento.id}", style = MaterialTheme.typography.bodyLarge)
        Text(text = "Producto:", style = MaterialTheme.typography.bodyLarge)
        ProductoItem(movimiento.producto)
        Text(text = "Lote:", style = MaterialTheme.typography.bodyLarge)
        if (movimiento.lote != null) {
            LoteItem(movimiento.lote)
        } else {
            Text(text = "       Sin lote\n")
        }
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
    }
}