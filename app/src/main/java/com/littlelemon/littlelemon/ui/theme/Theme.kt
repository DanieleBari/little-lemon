package com.littlelemon.littlelemon.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(
    primary = LLGreen,
    onPrimary = LLCloud,

    secondary = LLYellow,
    onSecondary = LLDark,

    tertiary = LLOrange,
    onTertiary = LLDark,

    background = LLCloud,
    onBackground = LLDark,

    surface = LLCloud,
    onSurface = LLDark,

    surfaceVariant = LLPeach,
    onSurfaceVariant = LLDark,

    outline = LLDark
)

@Composable
fun LittleLemonTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = Typography,
        content = content
    )
}