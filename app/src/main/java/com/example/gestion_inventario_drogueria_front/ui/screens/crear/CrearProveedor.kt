package com.example.gestion_inventario_drogueria_front.ui.screens.crear

import androidx.compose.runtime.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.gestion_inventario_drogueria_front.data.models.Proveedor
import com.example.gestion_inventario_drogueria_front.ui.components.BotonVolverAlMenu
import com.example.gestion_inventario_drogueria_front.ui.viewmodel.ProveedorViewModel

@Composable
fun CrearProveedorScreen(viewModel: ProveedorViewModel, navController: NavController) {
    var nombre by remember { mutableStateOf("") }
    var nit by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }
    var direccion by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var mensajeCreacion by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {

        BotonVolverAlMenu(navController)

        TextField(value = nombre, onValueChange = { nombre = it }, label = { Text("Nombre") })
        TextField(value = nit, onValueChange = { nit = it }, label = { Text("NIT") })
        TextField(value = telefono, onValueChange = { telefono = it }, label = { Text("Teléfono") })
        TextField(value = direccion, onValueChange = { direccion = it }, label = { Text("Dirección") })
        TextField(value = email, onValueChange = { email = it }, label = { Text("Corre electrónico") })

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            val proveedor = Proveedor(
                nombre = nombre,
                nit = nit,
                telefono = telefono,
                direccion = direccion,
                email = email
            )
            viewModel.crearProveedor(proveedor)
            mensajeCreacion = "Proveedor creado exitosamente"
        }) {
            Text("Crear Proveedor")
        }
        if (mensajeCreacion.isNotEmpty()) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = mensajeCreacion, color = MaterialTheme.colorScheme.primary)
        }
    }
}
