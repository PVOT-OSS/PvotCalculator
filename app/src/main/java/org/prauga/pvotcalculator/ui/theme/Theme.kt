package org.prauga.pvotcalculator.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

private val DarkColorScheme = darkColorScheme(
    primary = CalcOrange,
    onPrimary = CalcWhite,
    background = CalcBlack,
    onBackground = CalcWhite,
    surface = CalcDarkGray,
    onSurface = CalcWhite,
    secondaryContainer = CalcLightGray,
    onSecondaryContainer = CalcBlack,
    surfaceVariant = CalcBlack,
    onSurfaceVariant = CalcLightGray,
)

private val LightColorScheme = lightColorScheme(
    primary = CalcOrange,
    onPrimary = CalcWhite,
    background = LightBackground,
    onBackground = LightDisplayText,
    surface = LightDigitButton,
    onSurface = LightDisplayText,
    secondaryContainer = LightFunctionButton,
    onSecondaryContainer = LightDisplayText,
    surfaceVariant = LightBackground,
    onSurfaceVariant = LightExpressionText,
)

@Composable
fun CalculatorTheme(content: @Composable () -> Unit) {
    val isDark = isSystemInDarkTheme()
    val calcColors = if (isDark) DarkCalculatorColors else LightCalculatorColors
    val colorScheme = if (isDark) DarkColorScheme else LightColorScheme

    CompositionLocalProvider(LocalCalculatorColors provides calcColors) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = Typography,
            content = content
        )
    }
}
