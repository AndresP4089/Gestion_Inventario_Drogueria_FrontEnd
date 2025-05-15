package com.example.gestion_inventario_drogueria_front.ui.components.menu

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun BotonVolverAlMenu(navController: NavController) {
    Button(
        onClick = { navController.navigate("menu") },
        modifier = Modifier
            .padding(8.dp)
    ) {
        Text("Volver al Menú")
    }
}
