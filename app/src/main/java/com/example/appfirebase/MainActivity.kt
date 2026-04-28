package com.example.appfirebase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels // Importante para el ViewModel
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.appfirebase.login.LoginView
import com.example.appfirebase.login.LoginViewModel
import com.example.appfirebase.ui.theme.AuriumTheme

class MainActivity : ComponentActivity() {

    // Instanciamos el ViewModel usando la mejor práctica de Android
    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AuriumTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // ¡Aquí llamamos a nuestra pantalla de Login!
                    LoginView(
                        viewModel = loginViewModel,
                        onNavigateToHome = {
                            // Por ahora no tenemos la pantalla Home,
                            // así que dejaremos esto vacío temporalmente.
                        }
                    )
                }
            }
        }
    }
}