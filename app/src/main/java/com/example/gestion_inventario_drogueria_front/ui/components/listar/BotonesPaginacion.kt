package com.example.gestion_inventario_drogueria_front.ui.components.listar

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BotonesPaginacion(
    onAnterior: () -> Unit,
    onSiguiente: () -> Unit,
    puedeRetroceder: Boolean,
    puedeAvanzar: Boolean
) {
    Row {
        Button(
            onClick = onAnterior,
            enabled = puedeRetroceder
        ) {
            Text("Anterior")
        }

        Spacer(modifier = Modifier.width(8.dp))

        Button(
            onClick = onSiguiente,
            enabled = puedeAvanzar
        ) {
            Text("Siguiente")
        }
    }
}
