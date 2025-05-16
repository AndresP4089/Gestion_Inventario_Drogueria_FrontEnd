package com.example.gestion_inventario_drogueria_front.ui.screens.buscar

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.gestion_inventario_drogueria_front.ui.components.ProductoItem
import com.example.gestion_inventario_drogueria_front.ui.components.BotonesPaginacion
import com.example.gestion_inventario_drogueria_front.ui.components.BotonVolverAlMenu
import com.example.gestion_inventario_drogueria_front.ui.viewmodel.ProductoViewModel

@Composable
fun BuscarProductoPorNombreScreen(viewModel: ProductoViewModel, navController: NavController) {
    val productos by viewModel.productos.observeAsState(emptyList())
    var textoBusqueda by remember { mutableStateOf("") }

    // Lanzar búsqueda automática cuando se entre a esta pantalla
    LaunchedEffect(Unit) {
        if (textoBusqueda.isNotBlank()) {
            viewModel.iniciarBusqueda(textoBusqueda)
        } else {
            viewModel.limpiarBusqueda()
        }
    }

    Column (modifier = Modifier.padding(16.dp)){

        BotonVolverAlMenu(navController)

        // Input para el nombre a buscar
        TextField(
            value = textoBusqueda,
            onValueChange = { textoBusqueda = it },
            label = { Text("Nombre") }
        )

        Button(onClick = {
            viewModel.iniciarBusqueda(textoBusqueda)
        }) {
            Text("Buscar")
        }

        // Lista de resultados
        LazyColumn {
            items(productos) { producto ->
                ProductoItem(producto)
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