package com.example.gestion_inventario_drogueria_front.ui.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable

@Composable
fun AlertaNumLote(
    numeroLote: String,
    onNumeroLoteChange: (String) -> Unit,
    onConfirmar: () -> Unit,
    onCancelar: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onCancelar,
        title = { Text("Número de lote") },
        text = {
            TextField(
                value = numeroLote,
                onValueChange = onNumeroLoteChange,
                label = { Text("Número de lote") },
                singleLine = true
            )
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
