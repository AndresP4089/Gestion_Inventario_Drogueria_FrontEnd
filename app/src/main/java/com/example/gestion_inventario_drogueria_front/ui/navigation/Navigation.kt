package com.example.gestion_inventario_drogueria_front.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gestion_inventario_drogueria_front.ui.screens.buscar.BuscarProductoPorNombreScreen
import com.example.gestion_inventario_drogueria_front.ui.screens.menu.MenuPrincipalScreen
import com.example.gestion_inventario_drogueria_front.ui.screens.listar.ListarProductosScreen
import com.example.gestion_inventario_drogueria_front.ui.screens.buscar.BuscarProductoScreen
import com.example.gestion_inventario_drogueria_front.ui.screens.buscar.BuscarProveedorScreen
import com.example.gestion_inventario_drogueria_front.ui.screens.listar.ListarProveedoresScreen
import com.example.gestion_inventario_drogueria_front.ui.viewmodel.ProductoViewModel
import com.example.gestion_inventario_drogueria_front.ui.viewmodel.ProveedorViewModel

// Navegar entre screens, se configuran las rutas
@Composable
fun AppNavigation(productoViewModel: ProductoViewModel, proveedorViewModel: ProveedorViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "menu") {
        composable("menu") { MenuPrincipalScreen(navController) }

        // Añadir
        //composable("añadirProducto") { AñadirProductoScreen() }
        //composable("añadirProveedor") { AñadirProveedorScreen() }
        //composable("añadirMovimiento") { AñadirMovimientoScreen() }

        // Listar
        composable("listarProductos") { ListarProductosScreen(productoViewModel, navController) }
        composable("listarProveedores") { ListarProveedoresScreen(proveedorViewModel, navController) }
        //composable("listarMovimientos") { ListarMovimientosScreen() }

        // Buscar
        composable( "BuscarProducto") { BuscarProductoScreen(productoViewModel, navController)}
        composable( "BuscarProductoNombre") { BuscarProductoPorNombreScreen(productoViewModel, navController)}
        composable( "BuscarProveedor") { BuscarProveedorScreen(proveedorViewModel, navController)}
    }
}

