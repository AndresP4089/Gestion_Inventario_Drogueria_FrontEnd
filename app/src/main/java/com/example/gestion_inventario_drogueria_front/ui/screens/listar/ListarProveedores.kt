package com.example.gestion_inventario_drogueria_front.ui.screens.listar

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.gestion_inventario_drogueria_front.ui.components.BotonVolverAlMenu
import com.example.gestion_inventario_drogueria_front.ui.components.BotonesPaginacion
import com.example.gestion_inventario_drogueria_front.ui.components.ProveedorItem
import com.example.gestion_inventario_drogueria_front.ui.viewmodel.ProveedorViewModel

@Composable
fun ListarProveedoresScreen(viewModel: ProveedorViewModel, navController: NavController) {
    val proveedores by viewModel.proveedores.observeAsState(emptyList())

    // Cargar la primera página al mostrar la pantalla
    LaunchedEffect(Unit) {
        viewModel.cargarProveedores()
    }

    Column(modifier = Modifier.padding(16.dp)) {

        BotonVolverAlMenu(navController)

        // Lista de proveedores
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(proveedores) { proveedor ->
                ProveedorItem(proveedor)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Información de la página actual
        Text("Página ${viewModel.getPaginaActual()} de ${viewModel.getTotalPaginas()}")

        Spacer(modifier = Modifier.height(8.dp))

        // Botones de paginación
        BotonesPaginacion(
            onAnterior = { viewModel.paginacion.cargarPaginaAnterior() },
            onSiguiente = { viewModel.paginacion.cargarSiguientePagina() },
            puedeRetroceder = viewModel.paginacion.puedeRetrocederPagina(),
            puedeAvanzar = viewModel.paginacion.puedeAvanzarPagina()
        )
    }
}