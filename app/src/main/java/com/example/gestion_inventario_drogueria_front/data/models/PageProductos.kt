package com.example.gestion_inventario_drogueria_front.data.models

data class PaginaDeProductos(
    val content: List<Producto>,
    val totalPages: Int,
    val totalElements: Int,
    val number: Int
)
