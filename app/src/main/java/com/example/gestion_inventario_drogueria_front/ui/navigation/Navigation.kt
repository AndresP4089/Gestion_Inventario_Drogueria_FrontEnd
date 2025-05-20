package com.example.gestion_inventario_drogueria_front.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gestion_inventario_drogueria_front.ui.screens.buscar.BuscarLoteNumeroScreen
import com.example.gestion_inventario_drogueria_front.ui.screens.buscar.BuscarProductoPorNombreScreen
import com.example.gestion_inventario_drogueria_front.ui.screens.menu.MenuPrincipalScreen
import com.example.gestion_inventario_drogueria_front.ui.screens.listar.ListarProductosScreen
import com.example.gestion_inventario_drogueria_front.ui.screens.buscar.BuscarProductoScreen
import com.example.gestion_inventario_drogueria_front.ui.screens.buscar.BuscarProveedorScreen
import com.example.gestion_inventario_drogueria_front.ui.screens.buscar.BuscarProveedoresPorNombreScreen
import com.example.gestion_inventario_drogueria_front.ui.screens.crear.CrearProductoScreen
import com.example.gestion_inventario_drogueria_front.ui.screens.crear.CrearProveedorScreen
import com.example.gestion_inventario_drogueria_front.ui.screens.listar.ListarLotesIngresoScreen
import com.example.gestion_inventario_drogueria_front.ui.screens.listar.ListarLotesVencimientoScreen
import com.example.gestion_inventario_drogueria_front.ui.screens.listar.ListarMovimientosScreen
import com.example.gestion_inventario_drogueria_front.ui.screens.listar.ListarProveedoresScreen
import com.example.gestion_inventario_drogueria_front.ui.screens.listar.ListarReportesMovimientosScreen
import com.example.gestion_inventario_drogueria_front.ui.screens.listar.MostrarResumenReportesMovimientosScreen
import com.example.gestion_inventario_drogueria_front.ui.viewmodel.LoteViewModel
import com.example.gestion_inventario_drogueria_front.ui.viewmodel.MovimientoViewModel
import com.example.gestion_inventario_drogueria_front.ui.viewmodel.ProductoViewModel
import com.example.gestion_inventario_drogueria_front.ui.viewmodel.ProveedorViewModel

// Navegar entre screens, se configuran las rutas
@Composable
fun AppNavigation(
    productoViewModel: ProductoViewModel,
    proveedorViewModel: ProveedorViewModel,
    loteViewModel: LoteViewModel,
    movimientoViewModel: MovimientoViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "menu") {
        composable("menu") { MenuPrincipalScreen(navController) }

        // Añadir
        composable("añadirProducto") { CrearProductoScreen(productoViewModel, navController) }
        composable("añadirProveedor") { CrearProveedorScreen(proveedorViewModel, navController) }
        //composable("añadirMovimiento") { AñadirMovimientoScreen() }

        // Listar
        composable("listarProductos") { ListarProductosScreen(productoViewModel, navController) }
        composable("listarProveedores") { ListarProveedoresScreen(proveedorViewModel, navController) }
        composable("listarLotesIngreso") { ListarLotesIngresoScreen(loteViewModel, navController) }
        composable("listarLotesVencimiento") { ListarLotesVencimientoScreen(loteViewModel, navController) }
        composable("listarMovimientos") { ListarMovimientosScreen(movimientoViewModel, navController) }
        composable("listarReportesMovimientos") { ListarReportesMovimientosScreen(movimientoViewModel, navController) }
        composable("MostrarResumenReportes") { MostrarResumenReportesMovimientosScreen(movimientoViewModel, navController) }

        // Buscar
        composable( "BuscarProducto") { BuscarProductoScreen(productoViewModel, navController)}
        composable( "BuscarProductoNombre") { BuscarProductoPorNombreScreen(productoViewModel, navController)}
        composable( "BuscarProveedor") { BuscarProveedorScreen(proveedorViewModel, navController)}
        composable( "BuscarProveedorNombre") { BuscarProveedoresPorNombreScreen(proveedorViewModel, navController)}
        composable( "BuscarLoteNumero") { BuscarLoteNumeroScreen(loteViewModel, navController)}
    }
}

