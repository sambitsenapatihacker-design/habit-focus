package com.example.habitfocus.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val HabitFocusDarkScheme = darkColorScheme(
    primary = Violet,
    onPrimary = Color.White,
    primaryContainer = VioletContainer,
    onPrimaryContainer = OnVioletContainer,
    secondary = Amber,
    onSecondary = OnAmber,
    secondaryContainer = AmberContainer,
    onSecondaryContainer = OnAmberContainer,
    tertiary = Coral,
    onTertiary = OnCoral,
    background = DeepPlumBackground,
    onBackground = OnDeepPlum,
    surface = PlumSurface,
    onSurface = OnDeepPlum,
    surfaceVariant = PlumSurfaceVariant,
    onSurfaceVariant = OnPlumSurfaceVariant,
    outline = PlumOutline,
    error = Coral,
    onError = OnCoral
)

private val HabitFocusLightScheme = lightColorScheme(
    primary = Violet,
    onPrimary = Color.White,
    primaryContainer = OnVioletContainer,
    onPrimaryContainer = VioletContainer,
    secondary = Amber,
    onSecondary = OnAmber,
    tertiary = Coral,
    onTertiary = Color.White,
    background = LightBackground,
    onBackground = DeepPlumBackground,
    surface = LightSurface,
    onSurface = DeepPlumBackground
)

@Composable
fun HabitFocusTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) HabitFocusDarkScheme else HabitFocusLightScheme
    MaterialTheme(
        colorScheme = colorScheme,
        typography = HabitFocusTypography,
        content = content
    )
}
