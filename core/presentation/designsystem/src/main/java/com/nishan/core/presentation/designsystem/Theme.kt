package com.nishan.core.presentation.designsystem

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

val DarkColorScheme = darkColorScheme(
    primary = PacePalGreen,
    background = PacePalBlack,
    surface = PacePalDarkGray,
    secondary = PacePalWhite,
    tertiary = PacePalWhite,
    primaryContainer = PacePalGreen30,
    onPrimary = PacePalBlack,
    onBackground = PacePalWhite,
    onSurfaceVariant = PacePalGray,
    error = PacePalDarkRed
)

@Composable
fun PacePalTheme(
    content: @Composable () -> Unit
){
    val colorScheme = DarkColorScheme
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
//            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = false
        }
    }
    MaterialTheme(
        colorScheme =  colorScheme,
        typography = Typography,
        content = content
    )
}