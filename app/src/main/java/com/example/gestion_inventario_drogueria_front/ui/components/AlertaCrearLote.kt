package com.example.gestion_inventario_drogueria_front.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AlertaCrearLote(
    numeroLote: String,
    fechaVencimiento: String,
    nitProveedor: String,
    onNumeroLoteChange: (String) -> Unit,
    onFechaVencimientoChange: (String) -> Unit,
    onNitProveedorChange: (String) -> Unit,
    onConfirmar: () -> Unit,
    onCancelar: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onCancelar,
        title = { Text("Crear nuevo lote") },
        text = {
            Column {
                TextField(
                    value = numeroLote,
                    onValueChange = onNumeroLoteChange,
                    label = { Text("Número de lote") },
                    singleLine = true
                )

                Spacer(modifier = Modifier.height(8.dp))

                TextField(
                    value = fechaVencimiento,
                    onValueChange = onFechaVencimientoChange,
                    label = { Text("Fecha de vencimiento (YYYY-MM-DD)") },
                    singleLine = true
                )

                Spacer(modifier = Modifier.height(8.dp))

                TextField(
                    value = nitProveedor,
                    onValueChange = onNitProveedorChange,
                    label = { Text("NIT del proveedor") },
                    singleLine = true
                )
            }
        },
        confirmButton = {
            Button(onClick = onConfirmar) {
                Text("Confirmar")
            }
        },
        dismissButton = {
            TextButton(onClick = onCancelar) {
                Text("Cancelar")
            }
        }
    )
}

