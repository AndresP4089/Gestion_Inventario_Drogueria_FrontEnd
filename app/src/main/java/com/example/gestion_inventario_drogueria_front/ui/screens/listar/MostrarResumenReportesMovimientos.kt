package com.example.gestion_inventario_drogueria_front.ui.screens.listar

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.navigation.NavController
import com.example.gestion_inventario_drogueria_front.data.DTO.MovimientoFiltroDTO
import com.example.gestion_inventario_drogueria_front.ui.components.BotonVolverAlMenu
import com.example.gestion_inventario_drogueria_front.ui.components.BotonesPaginacion
import com.example.gestion_inventario_drogueria_front.ui.components.LoteItem
import com.example.gestion_inventario_drogueria_front.ui.components.MovimientoItem
import com.example.gestion_inventario_drogueria_front.ui.components.ReportesMovimientosItem
import com.example.gestion_inventario_drogueria_front.ui.components.ResumenReportesMovimientosItem
import com.example.gestion_inventario_drogueria_front.ui.viewmodel.MovimientoViewModel
import androidx.compose.runtime.livedata.observeAsState


@Composable
fun MostrarResumenReportesMovimientosScreen(viewModel: MovimientoViewModel, navController: NavController) {
    val resumen by viewModel.resumenReporte.observeAsState()

    var fechaExacta by remember { mutableStateOf("") }
    var fechaDesde by remember { mutableStateOf("") }
    var fechaHasta by remember { mutableStateOf("") }
    var tipoSeleccionado by remember { mutableStateOf<String?>(null) }
    var codigoProducto by remember { mutableStateOf("") }

    val opcionesTipo = listOf("ENTRADA", "SALIDA")

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {

        BotonVolverAlMenu(navController)

        Text("Filtros", style = MaterialTheme.typography.titleMedium)

        OutlinedTextField(
            value = fechaExacta,
            onValueChange = { fechaExacta = it },
            label = { Text("Fecha exacta (YYYY-MM-DD)") },
            modifier = Modifier.fillMaxWidth()
        )

        Text("O rango de fechas:")

        OutlinedTextField(
            value = fechaDesde,
            onValueChange = { fechaDesde = it },
            label = { Text("Fecha desde (YYYY-MM-DD)") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = fechaHasta,
            onValueChange = { fechaHasta = it },
            label = { Text("Fecha hasta (YYYY-MM-DD)") },
            modifier = Modifier.fillMaxWidth()
        )

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Tipo:", modifier = Modifier.padding(end = 8.dp))
            opcionesTipo.forEach { tipo ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = tipoSeleccionado == tipo,
                        onClick = {
                            tipoSeleccionado = if (tipoSeleccionado == tipo) null else tipo
                        }
                    )
                    Text(tipo, modifier = Modifier.padding(end = 8.dp))
                }
            }
        }

        OutlinedTextField(
            value = codigoProducto,
            onValueChange = { codigoProducto = it },
            label = { Text("Código de producto") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {
            // Validación
            if (fechaExacta.isNotBlank() && (fechaDesde.isNotBlank() || fechaHasta.isNotBlank())) {
                Log.e("Filtros", "No se puede usar fechaExacta y fechaDesde/fechaHasta al mismo tiempo")
                return@Button
            }

            // Crear DTO y llamar al ViewModel
            val filtro = MovimientoFiltroDTO(
                fechaExacta = fechaExacta.takeIf { it.isNotBlank() },
                fechaDesde = fechaDesde.takeIf { it.isNotBlank() },
                fechaHasta = fechaHasta.takeIf { it.isNotBlank() },
                tipoMovimiento = tipoSeleccionado,
                codigoProducto = codigoProducto.takeIf { it.isNotBlank() }
            )

            viewModel.obtenerResumenReporte(filtro)
        }) {
            Text("Buscar")
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(modifier = Modifier.weight(1f)) {
            item {
                resumen?.let {
                    ResumenReportesMovimientosItem(it)
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Página ${viewModel.getPaginaActual()} de ${viewModel.getTotalPaginas()}")

        Spacer(modifier = Modifier.height(8.dp))

        BotonesPaginacion(
            onAnterior = { viewModel.paginacion.cargarPaginaAnterior() },
            onSiguiente = { viewModel.paginacion.cargarSiguientePagina() },
            puedeRetroceder = viewModel.paginacion.puedeRetrocederPagina(),
            puedeAvanzar = viewModel.paginacion.puedeAvanzarPagina()
        )
    }
}