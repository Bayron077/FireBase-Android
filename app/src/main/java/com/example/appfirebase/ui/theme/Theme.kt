package com.example.appfirebase.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = AuriumOrange,
    secondary = AuriumYellow,
    tertiary = AuriumLight,
    background = AuriumNavy, // En modo oscuro, el fondo es tu azul marino
    surface = AuriumNavy,
    onPrimary = AuriumNavy,
    onBackground = AuriumLight,
    onSurface = AuriumLight,
    error = AuriumError
)

private val LightColorScheme = lightColorScheme(
    primary = AuriumNavy, // En modo claro, usamos el azul marino como color principal de marca
    secondary = AuriumOrange,
    tertiary = AuriumYellow,
    background = AuriumLight, // Fondo claro
    surface = Color(0xFFFFFFFF), // Superficie de tarjetas blanca
    onPrimary = AuriumLight,
    onBackground = AuriumNavy,
    onSurface = AuriumNavy,
    error = AuriumError
)

@Composable
fun AuriumTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color es para Android 12+, lo apagamos por defecto para mantener la identidad de tu marca
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.background.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}