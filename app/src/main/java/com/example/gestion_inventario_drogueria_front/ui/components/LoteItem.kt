package com.example.gestion_inventario_drogueria_front.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.gestion_inventario_drogueria_front.data.models.Lote


// Componente reutilizable de productos
@Composable
fun LoteItem(lote: Lote) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)) {
        Text(text = "----------------------------------", style = MaterialTheme.typography.bodyLarge)
        Text(text = lote.numeroLote, style = MaterialTheme.typography.bodyLarge)
        Text(text = "Fecha Vencimiento: \$${lote.fechaVencimiento}")
        Text(text = "Fecha Ingreso: ${lote.fechaIngreso}")
        Text(text = "Producto:", style = MaterialTheme.typography.bodyLarge)
        ProductoItem(lote.producto)
        Text(text = "Proveedor:", style = MaterialTheme.typography.bodyLarge)
        ProveedorItem(lote.proveedor)
    }
}