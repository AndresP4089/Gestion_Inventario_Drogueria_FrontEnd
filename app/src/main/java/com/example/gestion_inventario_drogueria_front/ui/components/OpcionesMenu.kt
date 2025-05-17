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

    // Productos
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

    // Proveedores
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

            Button(onClick = { navController.navigate("listarProveedores") }) {
                Text("Listar Proveedores")
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(onClick = { navController.navigate("BuscarProveedor") }) {
                Text("Buscar Proveedor NIT")
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(onClick = { navController.navigate("BuscarProveedorNombre") }) {
                Text("Buscar Proveedor Nombre")
            }
        }
    }

    Spacer(modifier = Modifier.height(24.dp))

    // Lotes
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

            Button(onClick = { navController.navigate("listarLotesIngreso") }) {
                Text("Listar Lotes Fecha Ingreso")
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(onClick = { navController.navigate("listarLotesVencimiento") }) {
                Text("Listar Lotes Fecha Vencimiento")
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(onClick = { navController.navigate("BuscarLoteNumero") }) {
                Text("Buscar Lote Numero")
            }
        }
    }

    Spacer(modifier = Modifier.height(24.dp))

    // Movimientos
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

            Button(onClick = { navController.navigate("listarMovimientos") }) {
                Text("Listar Movimientos")
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(onClick = { navController.navigate("BuscarProducto") }) {
                Text("Buscar Producto")
            }
        }
    }

    Spacer(modifier = Modifier.height(24.dp))
}