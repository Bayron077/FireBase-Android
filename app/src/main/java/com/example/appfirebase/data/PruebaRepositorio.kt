package com.example.appfirebase.data

import com.google.firebase.database.FirebaseDatabase

class PruebaRepositorio {

    private val database = FirebaseDatabase.getInstance()
    private val ref = database.getReference("usuarios")


    fun guardarUsuario(id: String, nombre: String, edad: Int) {
        val datos = mapOf(
            "nombre" to nombre,
            "edad" to edad
        )
        ref.child(id).setValue(datos)
    }

    fun obtenerUsuario(id: String, onResult: (String?) -> Unit) {
        ref.child(id).get().addOnSuccessListener { snapshot ->
            val nombre = snapshot.child("nombre").getValue(String::class.java)
            onResult(nombre)
        }
    }
}