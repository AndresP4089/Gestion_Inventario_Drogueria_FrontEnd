package com.example.gestion_inventario_drogueria_front.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.gestion_inventario_drogueria_front.ui.viewmodel.ProductoViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.getValue
import androidx.compose.foundation.lazy.items
import com.example.gestion_inventario_drogueria_front.ui.components.ProductoItem

// Pantallas que tendra la app
@Composable
fun InventarioScreen(viewModel: ProductoViewModel = viewModel()) {
    val productos by viewModel.productos.observeAsState(emptyList())

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {

        Text("Inventario", style = MaterialTheme.typography.titleLarge)

        Button(onClick = { viewModel.cargarProductos() }) {
            Text("Cargar Productos")
        }

        LazyColumn {
            items(productos) { producto ->
                ProductoItem(producto)
            }
        }
    }
}