package com.example.gestion_inventario_drogueria_front

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.gestion_inventario_drogueria_front.ui.navigation.AppNavigation
import com.example.gestion_inventario_drogueria_front.ui.viewmodel.ProductoViewModel
import com.example.gestion_inventario_drogueria_front.ui.viewmodel.ProveedorViewModel
import com.example.gestion_inventario_drogueria_front.ui.viewmodel.LoteViewModel
import com.example.gestion_inventario_drogueria_front.ui.viewmodel.MovimientoViewModel

/* Es la pantalla que ve el usuario. Observa los datos del ViewModel y los muestra:
🔹 Aquí es donde conectas la vista con los datos.
🔹 Idealmente debería tener solo lógica visual.
 */
class MainActivity : ComponentActivity() {
    private val productoViewModel by viewModels<ProductoViewModel>()
    private val proveedorViewModel by viewModels<ProveedorViewModel>()
    private val loteViewModel by viewModels<LoteViewModel>()
    private val movimientoViewModel by viewModels<MovimientoViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNavigation(
                productoViewModel = productoViewModel,
                proveedorViewModel = proveedorViewModel,
                loteViewModel = loteViewModel,
                movimientoViewModel = movimientoViewModel
            )
        }
    }
}