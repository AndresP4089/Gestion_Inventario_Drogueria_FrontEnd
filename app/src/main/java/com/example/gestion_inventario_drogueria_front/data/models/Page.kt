package com.example.gestion_inventario_drogueria_front.data.models

data class Page<T>(
    val content: List<T>,
    val totalElements: Int,
    val totalPages: Int,
    val number: Int
)

