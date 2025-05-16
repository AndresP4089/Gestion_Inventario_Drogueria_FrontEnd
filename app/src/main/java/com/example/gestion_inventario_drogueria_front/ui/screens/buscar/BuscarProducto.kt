package com.example.gestion_inventario_drogueria_front.ui.screens.buscar

import androidx.compose.material3.TextField
import androidx.compose.runtime.remember
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.gestion_inventario_drogueria_front.ui.components.ProductoItem
import com.example.gestion_inventario_drogueria_front.ui.components.BotonVolverAlMenu
import com.example.gestion_inventario_drogueria_front.ui.viewmodel.ProductoViewModel

// Buscar por codigo
@Composable
fun BuscarProductoScreen(viewModel: ProductoViewModel, navController: NavController) {
    var codigo by remember { mutableStateOf("") }
    val productoBuscado by viewModel.productoBuscado.observeAsState()

    Column (modifier = Modifier.padding(16.dp)){

        BotonVolverAlMenu(navController)

        TextField(
            value = codigo,
            onValueChange = { codigo = it },
            label = { Text("Código") }
        )

        Button(onClick = { viewModel.obtenerPorCodigo(codigo)}) {
            Text("Buscar")
        }

        productoBuscado?.let { producto ->
            ProductoItem(producto)
        } ?: Text("Producto no encontrado o no buscado aún.")
    }
}