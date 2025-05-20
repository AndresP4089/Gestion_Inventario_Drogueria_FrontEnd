package com.example.gestion_inventario_drogueria_front.ui.screens.crear

import androidx.compose.runtime.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.gestion_inventario_drogueria_front.data.models.Producto
import com.example.gestion_inventario_drogueria_front.ui.components.BotonVolverAlMenu
import com.example.gestion_inventario_drogueria_front.ui.viewmodel.ProductoViewModel

@Composable
fun CrearProductoScreen(viewModel: ProductoViewModel, navController: NavController) {
    var nombre by remember { mutableStateOf("") }
    var codigo by remember { mutableStateOf("") }
    var precioUnitario by remember { mutableStateOf("") }
    var laboratorio by remember { mutableStateOf("") }
    var principioActivo by remember { mutableStateOf("") }
    var presentacion by remember { mutableStateOf("") }
    var unidadMedida by remember { mutableStateOf("") }
    var stockMinimo by remember { mutableStateOf("") }
    var controladoPorLote by remember { mutableStateOf(false) }
    var mensajeCreacion by remember { mutableStateOf("") }
    var descripcion by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {

        BotonVolverAlMenu(navController)

        TextField(value = nombre, onValueChange = { nombre = it }, label = { Text("Nombre") })
        TextField(value = codigo, onValueChange = { codigo = it }, label = { Text("Código") })
        TextField(
            value = precioUnitario,
            onValueChange = { precioUnitario = it },
            label = { Text("Precio Unitario") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        TextField(value = laboratorio, onValueChange = { laboratorio = it }, label = { Text("Laboratorio") })
        TextField(value = principioActivo, onValueChange = { principioActivo = it }, label = { Text("Principio Activo") })
        TextField(value = presentacion, onValueChange = { presentacion = it }, label = { Text("Presentación") })
        TextField(value = unidadMedida, onValueChange = { unidadMedida = it }, label = { Text("Unidad de Medida") })
        TextField(
            value = stockMinimo,
            onValueChange = { stockMinimo = it },
            label = { Text("Stock Mínimo") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        OutlinedTextField(value = descripcion, onValueChange = { descripcion = it }, label = { Text("Descripción") })

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = controladoPorLote, onCheckedChange = { controladoPorLote = it })
            Text("¿Controlado por Lote?")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            val producto = Producto(
                nombre = nombre,
                codigo = codigo,
                precioUnitario = precioUnitario.toDoubleOrNull() ?: 0.0,
                laboratorio = laboratorio,
                principioActivo = principioActivo,
                presentacion = presentacion,
                unidadMedida = unidadMedida,
                stockMinimo = stockMinimo.toIntOrNull() ?: 0,
                controladoPorLote = controladoPorLote,
                descripcion = descripcion
            )
            viewModel.crearProducto(producto)
            mensajeCreacion = "Producto creado exitosamente"
        }) {
            Text("Crear Producto")
        }
        if (mensajeCreacion.isNotEmpty()) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = mensajeCreacion, color = MaterialTheme.colorScheme.primary)
        }
    }
}
