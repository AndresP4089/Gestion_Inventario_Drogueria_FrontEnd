package com.example.gestion_inventario_drogueria_front.ui.screens.crear

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.gestion_inventario_drogueria_front.data.DTO.DTOLoteRequest
import com.example.gestion_inventario_drogueria_front.data.DTO.DTOMovimientoRequest
import com.example.gestion_inventario_drogueria_front.ui.components.AlertaCrearLote
import com.example.gestion_inventario_drogueria_front.ui.components.AlertaNumLote
import com.example.gestion_inventario_drogueria_front.ui.components.BotonVolverAlMenu
import com.example.gestion_inventario_drogueria_front.ui.viewmodel.MovimientoViewModel

@Composable
fun CrearMovimientoScreen(
    viewModel: MovimientoViewModel,
    navController: NavController
) {
    // variables usadas en todos los casos
    var codigoProducto by remember { mutableStateOf("") }
    var cantidad by remember { mutableStateOf("") }
    var tipo by remember { mutableStateOf("") }
    var precioCompraVenta by remember { mutableStateOf("") }
    var mensajeCreacion by remember { mutableStateOf("") }
    var observaciones by remember { mutableStateOf("") }
    var motivo by remember { mutableStateOf("") }

    // Para el caso de salida producto controlado por lote
    var mostrarDialogoLote by remember { mutableStateOf(false) }
    var movimientoPendiente by remember { mutableStateOf<DTOMovimientoRequest?>(null) }
    var numeroLote by remember { mutableStateOf("") }

    // Para el caso entrada producto controlado por lote
    var mostrarDialogoCrearLote by remember { mutableStateOf(false) }
    var fechaVencimiento by remember { mutableStateOf("") }
    var nitProveedor by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        BotonVolverAlMenu(navController)

        // Ingresar codigo producto
        OutlinedTextField(
            value = codigoProducto,
            onValueChange = { codigoProducto = it },
            label = { Text("Código del Producto") },
            modifier = Modifier.fillMaxWidth()
        )

        // Ingresar cantidad
        OutlinedTextField(
            value = cantidad,
            onValueChange = { cantidad = it },
            label = { Text("Cantidad") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        // Ingresar precio
        OutlinedTextField(
            value = precioCompraVenta,
            onValueChange = { precioCompraVenta = it },
            label = { Text("Precio") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        // Ingresar observaciones
        OutlinedTextField(value = observaciones, onValueChange = { observaciones = it }, label = { Text("Observaciones") })

        // Ingresar motivo
        OutlinedTextField(value = motivo, onValueChange = { motivo = it }, label = { Text("Motivo") })


        Text("Tipo de Movimiento", style = MaterialTheme.typography.bodyLarge)


        // Seleccionar tipo movimiento
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = tipo == "ENTRADA",
                onClick = { tipo = "ENTRADA" }
            )
            Text("Entrada", modifier = Modifier.clickable { tipo = "ENTRADA" })

            Spacer(modifier = Modifier.width(16.dp))

            RadioButton(
                selected = tipo == "SALIDA",
                onClick = { tipo = "SALIDA" }
            )
            Text("Salida", modifier = Modifier.clickable { tipo = "SALIDA" })
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            val cantidadInt = cantidad.toIntOrNull() ?: 0
            val precioDouble = precioCompraVenta.toDoubleOrNull() ?: 0.0

            viewModel.verificarProducto(codigoProducto) { esControladoPorLote ->
                val movimiento = DTOMovimientoRequest(
                    codigoProducto = codigoProducto,
                    cantidad = cantidadInt,
                    tipo = tipo,
                    precioCompraVenta = precioDouble,
                    observaciones = observaciones,
                    motivo = motivo
                )

                if (esControladoPorLote && tipo == "SALIDA") {
                    movimientoPendiente = movimiento
                    mostrarDialogoLote = true
                } else if (esControladoPorLote && tipo == "ENTRADA") {
                    movimientoPendiente = movimiento
                    mostrarDialogoCrearLote = true
                } else {
                    viewModel.crearMovimiento(movimiento)
                    mensajeCreacion = "Movimiento creado exitosamente"
                }
            }
        }) {
            Text("Crear Movimiento")
        }

        // Diálogo para pedir número de lote
        if (mostrarDialogoLote) {
            AlertaNumLote(
                numeroLote = numeroLote,
                onNumeroLoteChange = { numeroLote = it },
                onConfirmar = {
                    movimientoPendiente?.let {
                        val movimientoConLote = it.copy(numeroLote = numeroLote)
                        viewModel.crearMovimiento(movimientoConLote)
                        mensajeCreacion = "Movimiento creado exitosamente"
                    }
                    mostrarDialogoLote = false
                    numeroLote = ""
                    movimientoPendiente = null
                },
                onCancelar = {
                    mostrarDialogoLote = false
                    numeroLote = ""
                    movimientoPendiente = null
                }
            )
        }

        // Diálogo para crear lote
        if (mostrarDialogoCrearLote) {
            AlertaCrearLote(
                numeroLote = numeroLote,
                fechaVencimiento = fechaVencimiento,
                nitProveedor = nitProveedor,
                onNumeroLoteChange = { numeroLote = it },
                onFechaVencimientoChange = { fechaVencimiento = it },
                onNitProveedorChange = { nitProveedor = it },
                onConfirmar = {
                    movimientoPendiente?.let {
                        val nuevoLote = DTOLoteRequest(
                            numeroLote = numeroLote,
                            fechaVencimiento = fechaVencimiento,
                            codigoProducto = it.codigoProducto,
                            nitProveedor = nitProveedor
                        )
                        val movimientoConLote = it.copy(lote = nuevoLote)

                        viewModel.crearMovimiento(movimientoConLote)
                        mensajeCreacion = "Movimiento creado exitosamente"
                    }
                    mostrarDialogoCrearLote = false
                    numeroLote = ""
                    fechaVencimiento = ""
                    nitProveedor = ""
                    movimientoPendiente = null
                },
                onCancelar = {
                    mostrarDialogoCrearLote = false
                    numeroLote = ""
                    fechaVencimiento = ""
                    nitProveedor = ""
                    movimientoPendiente = null
                }
            )
        }


        if (mensajeCreacion.isNotEmpty()) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = mensajeCreacion, color = MaterialTheme.colorScheme.primary)
        }
    }
}
