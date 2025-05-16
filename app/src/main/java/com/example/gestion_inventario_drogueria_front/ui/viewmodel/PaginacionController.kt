package com.example.gestion_inventario_drogueria_front.ui.viewmodel

class PaginacionController(
    private val cargarPagina: (Int) -> Unit,
    private val puedeAvanzar: () -> Boolean,
    private val puedeRetroceder: () -> Boolean
) {
    fun cargarSiguientePagina() {
        if (puedeAvanzar()) {
            cargarPagina(+1)
        }
    }

    fun cargarPaginaAnterior() {
        if (puedeRetroceder()) {
            cargarPagina(-1)
        }
    }

    fun puedeAvanzarPagina() = puedeAvanzar()
    fun puedeRetrocederPagina() = puedeRetroceder()
}
