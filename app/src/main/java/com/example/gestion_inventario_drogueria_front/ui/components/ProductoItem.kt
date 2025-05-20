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
import com.example.gestion_inventario_drogueria_front.data.models.Producto


// Componente reutilizable de productos
@Composable
fun ProductoItem(producto: Producto) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
            .padding(8.dp)
    ) {
        Text(text = "Producto: ${producto.nombre}", style = MaterialTheme.typography.bodyLarge)
        Text(text = "Precio: \$${producto.precioUnitario}")
        Text(text = "Descripción: ${producto.descripcion}")
    }
}