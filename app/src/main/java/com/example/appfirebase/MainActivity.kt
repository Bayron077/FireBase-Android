package com.example.appfirebase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.appfirebase.data.PruebaViewModel
import com.example.appfirebase.login.LoginViewModel
import com.example.appfirebase.navigation.AppNavigation
import com.example.appfirebase.ui.theme.AuriumTheme

class MainActivity : ComponentActivity() {

    private val loginViewModel: LoginViewModel by viewModels()
    private val pruebaViewModel: PruebaViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        pruebaViewModel.guardar("usuario1","Bayron", 24)
        setContent {
            AuriumTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // El director de tráfico toma el control de la app
                    AppNavigation(loginViewModel = loginViewModel)

                }
            }
        }
    }
}