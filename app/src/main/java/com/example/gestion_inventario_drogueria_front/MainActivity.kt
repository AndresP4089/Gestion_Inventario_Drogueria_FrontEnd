package com.example.gestion_inventario_drogueria_front

import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.gestion_inventario_drogueria_front.R
import com.example.gestion_inventario_drogueria_front.ui.viewmodel.ProductoViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: ProductoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtProductos = findViewById<TextView>(R.id.txtProductos)

        viewModel.productos.observe(this) { productos ->
            val texto = productos.joinToString("\n") {
                "${it.nombre} - \$${it.precioUnitario} - Stock: ${it.descripcion}"
            }
            txtProductos.text = texto
        }

        viewModel.cargarProductos()
    }
}