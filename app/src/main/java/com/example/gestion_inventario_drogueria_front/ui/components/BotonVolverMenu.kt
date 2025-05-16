package com.example.gestion_inventario_drogueria_front.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun BotonVolverAlMenu(navController: NavController) {
    Button(
        onClick = { navController.navigate("menu") }
    ) {
        Text("Volver al Menú")
    }

    Spacer(modifier = Modifier.height(16.dp))
}
