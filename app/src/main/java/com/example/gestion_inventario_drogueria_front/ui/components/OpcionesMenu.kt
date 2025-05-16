package com.example.gestion_inventario_drogueria_front.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun OpcionesMenu (navController: NavController) {
    Text("Menú principal", style = MaterialTheme.typography.titleLarge)
    Spacer(modifier = Modifier.height(8.dp))

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF0F0F0))
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Productos",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Button(onClick = { navController.navigate("añadirProducto") }) {
                Text("Añadir Producto")
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(onClick = { navController.navigate("listarProductos") }) {
                Text("Listar Productos")
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(onClick = { navController.navigate("BuscarProducto") }) {
                Text("Buscar Producto Codigo")
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(onClick = { navController.navigate("BuscarProductoNombre") }) {
                Text("Buscar Producto Nombre")
            }
        }
    }

    Spacer(modifier = Modifier.height(24.dp))

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF0F0F0))
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Proveedor",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Button(onClick = { navController.navigate("añadirProducto") }) {
                Text("Añadir Producto")
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(onClick = { navController.navigate("listarProductos") }) {
                Text("Listar Productos")
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(onClick = { navController.navigate("BuscarProducto") }) {
                Text("Buscar Producto")
            }
        }
    }

    Spacer(modifier = Modifier.height(24.dp))

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF0F0F0))
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Lote",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Button(onClick = { navController.navigate("añadirProducto") }) {
                Text("Añadir Producto")
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(onClick = { navController.navigate("listarProductos") }) {
                Text("Listar Productos")
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(onClick = { navController.navigate("BuscarProducto") }) {
                Text("Buscar Producto")
            }
        }
    }

    Spacer(modifier = Modifier.height(24.dp))

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF0F0F0))
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Movimiento Inventario",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Button(onClick = { navController.navigate("añadirProducto") }) {
                Text("Añadir Producto")
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(onClick = { navController.navigate("listarProductos") }) {
                Text("Listar Productos")
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(onClick = { navController.navigate("BuscarProducto") }) {
                Text("Buscar Producto")
            }
        }
    }

    Spacer(modifier = Modifier.height(24.dp))
}