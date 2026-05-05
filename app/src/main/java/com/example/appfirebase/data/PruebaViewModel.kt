package com.example.appfirebase.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel


class PruebaViewModel : ViewModel() {

    private val repository = PruebaRepositorio()

    var nombre by mutableStateOf<String?>(null)
        private set

    fun guardar(id: String, nombre: String, edad: Int) {
        repository.guardarUsuario("usuario1","Bayron",24)
    }

    fun obtener(id: String) {
        repository.obtenerUsuario(id) { resultado ->
            nombre = resultado
        }
    }
}
