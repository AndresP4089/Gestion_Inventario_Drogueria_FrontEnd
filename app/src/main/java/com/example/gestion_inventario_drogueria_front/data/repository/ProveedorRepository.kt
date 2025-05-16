package com.example.gestion_inventario_drogueria_front.data.repository

import com.example.gestion_inventario_drogueria_front.data.api.ProveedorApi
import com.example.gestion_inventario_drogueria_front.data.api.RetrofitInstance
import com.example.gestion_inventario_drogueria_front.data.models.Page
import com.example.gestion_inventario_drogueria_front.data.models.Proveedor

class ProveedorRepository {

    private val retrofitService = RetrofitInstance.retrofit.create(ProveedorApi::class.java)

    // Obtener todos
    suspend fun obtenerProveedores(pagina: Int): Page<Proveedor> {
        return retrofitService.obtenerProveedores(pagina)
    }

    // Buscar por nit
    suspend fun obtenerProveedoresPorNit(nit: String): Proveedor {
        return retrofitService.obtenerProveedoresPorNit(nit)
    }

    // Obtener por nombre
    suspend fun obtenerProveedoresPorNombre(pagina: Int, nombre: String): Page<Proveedor> {
        return retrofitService.obtenerProveedoresPorNombre(pagina, nombre)
    }
}