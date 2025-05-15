package com.example.gestion_inventario_drogueria_front

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.*
import com.example.gestion_inventario_drogueria_front.ui.viewmodel.ProductoViewModel
import com.example.gestion_inventario_drogueria_front.ui.screens.buscar.BuscarProductoScreen
import com.example.gestion_inventario_drogueria_front.ui.screens.listar.ListarProductosScreen

/* Es la pantalla que ve el usuario. Observa los datos del ViewModel y los muestra:
🔹 Aquí es donde conectas la vista con los datos.
🔹 Idealmente debería tener solo lógica visual.
 */
class MainActivity : ComponentActivity() {

    private val viewModel: ProductoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                BuscarProductoScreen(viewModel)
            }
        }
    }
}