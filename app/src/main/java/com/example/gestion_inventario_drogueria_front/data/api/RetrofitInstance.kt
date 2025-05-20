package com.example.gestion_inventario_drogueria_front.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/* Es la clase que configura Retrofit para conectarse al backend:
🔹 Solo se crea una vez (object = singleton).
🔹 Usa Gson para convertir JSON en objetos Kotlin.
🔹 Conecta con 10.0.2.2 que es el alias de localhost en Android Emulator.
 */

object RetrofitInstance {
    private const val BASE_URL_2 = "http://10.0.2.2:8080/api/"
    private const val BASE_URL = "http://192.168.10.83:8080/api/"

    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL_2)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}