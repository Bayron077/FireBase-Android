package com.example.appfirebase.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appfirebase.home.HomeView
import com.example.appfirebase.login.LoginView
import com.example.appfirebase.login.LoginViewModel

@Composable
fun AppNavigation(loginViewModel: LoginViewModel) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppScreens.Login.route
    ) {
        // Pantalla de Login
        composable(route = AppScreens.Login.route) {
            LoginView(
                viewModel = loginViewModel,
                onNavigateToHome = {
                    // Navegamos al Home y limpiamos el historial para que no pueda volver al Login con el botón "Atrás"
                    navController.navigate(AppScreens.Home.route) {
                        popUpTo(AppScreens.Login.route) { inclusive = true }
                    }
                }
            )
        }

        // Pantalla de Home
        composable(route = AppScreens.Home.route) {
            HomeView()
        }
    }
}