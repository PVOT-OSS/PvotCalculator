package org.prauga.pvotcalculator.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.prauga.pvot.designsystem.theme.PvotAppTheme

@Composable
fun CalculatorTheme(content: @Composable () -> Unit) {
    val isDark = isSystemInDarkTheme()
    val calcColors = if (isDark) DarkCalculatorColors else LightCalculatorColors

    PvotAppTheme(darkTheme = isDark) {
        CompositionLocalProvider(LocalCalculatorColors provides calcColors) {
            content()
        }
    }
}
