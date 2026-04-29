package com.example.appfirebase.navigation

sealed class AppScreens(val route: String) {
    object Login : AppScreens("login_route")
    object Home : AppScreens("home_route")
}