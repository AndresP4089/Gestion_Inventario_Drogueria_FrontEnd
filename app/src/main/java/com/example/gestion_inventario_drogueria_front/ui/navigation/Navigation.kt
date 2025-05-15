package com.example.gestion_inventario_drogueria_front.ui.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.gestion_inventario_drogueria_front.ui.screens.MenuPrincipalScreen
import com.example.gestion_inventario_drogueria_front.ui.screens.listar.ListarProductosScreen
import com.example.gestion_inventario_drogueria_front.ui.viewmodel.ProductoViewModel

// Navegar entre screens, se configura cuando ya se tienen todos definidos
@Composable
fun AppNavigation(navController: NavHostController) {

    val viewModel: ProductoViewModel = viewModel()


    NavHost(navController = navController, startDestination = "menu") {
        composable("menu") {
            MenuPrincipalScreen(navController)
        }
        composable("inventario") {
            ListarProductosScreen(viewModel)
        }
        // Puedes agregar más rutas como "agregarProducto"
    }
}
