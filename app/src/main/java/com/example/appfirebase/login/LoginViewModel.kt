package com.example.appfirebase.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    var uiState by mutableStateOf(LoginUiState())
        private set



    fun onPhoneNumberChanged(newNumber: String) {
        // Solo permitimos dígitos y un máximo razonable para teléfonos (ej. 10 a 15)
        if (newNumber.all { it.isDigit() } && newNumber.length <= 15) {
            uiState = uiState.copy(phoneNumber = newNumber, errorMessage = null)
        }
    }

    fun onPinChanged(newPin: String) {
        // Solo permitimos dígitos y exactamente hasta 4 caracteres
        if (newPin.all { it.isDigit() } && newPin.length <= 4) {
            uiState = uiState.copy(pin = newPin, errorMessage = null)
        }
    }

    fun login(onNavigateToHome: () -> Unit) {
        if (!uiState.isLoginValid) return

        viewModelScope.launch {
            uiState = uiState.copy(isLoading =  true, errorMessage = null)
            
            // TODO: Aquí implementaremos la llamada al Repositorio / Firebase
            // Por ahora simularemos un retraso de red
            delay(2000) 

            // Simulación de validación exitosa
            val success = true 
            
            if (success) {
                uiState = uiState.copy(isLoading = false)
                onNavigateToHome()
            } else {
                uiState = uiState.copy(
                    isLoading = false,
                    errorMessage = "Credenciales incorrectas"

                )
            }
        }
    }
}


data class LoginUiState(
    val phoneNumber: String = "",
    val pin: String = "",
    val isLoading: Boolean = false,
    val errorMessage: String? = null
) {
    // Validación básica para habilitar el botón de login
    val isLoginValid: Boolean
        get() = phoneNumber.length >= 10 && pin.length == 4
}
fun testFirebase() {
    val database = FirebaseDatabase.getInstance()
    val ref = database.getReference("test")

    ref.setValue("Hola mundo")
}