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
import com.example.gestion_inventario_drogueria_front.ui.components.LoteItem
import com.example.gestion_inventario_drogueria_front.ui.components.BotonVolverAlMenu
import com.example.gestion_inventario_drogueria_front.ui.viewmodel.LoteViewModel

// Buscar por numero lote
@Composable
fun BuscarLoteNumeroScreen(viewModel: LoteViewModel, navController: NavController) {
    var numLote by remember { mutableStateOf("") }
    val loteBuscado by viewModel.loteBuscado.observeAsState()

    Column (modifier = Modifier.padding(16.dp)){

        BotonVolverAlMenu(navController)

        TextField(
            value = numLote,
            onValueChange = { numLote = it },
            label = { Text("Número lote") }
        )

        Button(onClick = { viewModel.obtenerPorNumeroLote(numLote)}) {
            Text("Buscar")
        }

        loteBuscado?.let { lote ->
            LoteItem(lote)
        } ?: Text("Producto no encontrado o no buscado aún.")
    }
}