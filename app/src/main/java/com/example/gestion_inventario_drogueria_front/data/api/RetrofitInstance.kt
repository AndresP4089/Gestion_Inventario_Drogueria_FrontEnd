package com.example.gestion_inventario_drogueria_front.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Corregir la URL cuando sea en supabase
object RetrofitInstance {
    private const val BASE_URL = "http://10.0.2.2:8080/api/"  // O usa tu URL de backend si no es local

    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}