package com.example.gestion_inventario_drogueria_front.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun MenuPrincipalScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Menú Principal", style = MaterialTheme.typography.titleLarge)

        Button(onClick = { navController.navigate("inventario") }) {
            Text("Ver Inventario")
        }

        Button(onClick = { navController.navigate("agregarProducto") }) {
            Text("Agregar Producto")
        }

        // Agrega más opciones según necesites
    }
}
