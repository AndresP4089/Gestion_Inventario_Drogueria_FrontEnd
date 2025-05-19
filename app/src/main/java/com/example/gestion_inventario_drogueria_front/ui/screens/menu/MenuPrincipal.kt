package com.example.gestion_inventario_drogueria_front.ui.screens.menu

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController


// Pantalla que tiene los botones de opciones
@Composable
fun MenuPrincipalScreen(navController: NavHostController) {
    Column(modifier = Modifier.padding(16.dp)) {

        LazyColumn(modifier = Modifier.weight(1f)) {
            item {
                OpcionesMenu(navController)
            }
        }

    }
}

