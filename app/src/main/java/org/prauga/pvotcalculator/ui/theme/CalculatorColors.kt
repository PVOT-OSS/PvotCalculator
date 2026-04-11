package org.prauga.pvotcalculator.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

/**
 * Semantic color tokens for the calculator UI.
 * Consuming composables read from [LocalCalculatorColors] — they never reference
 * raw color constants directly, which keeps dark/light switching transparent.
 */
@Immutable
data class CalculatorColors(
    val background: Color,
    val displayText: Color,
    val expressionText: Color,
    val digitButton: Color,
    val digitButtonText: Color,
    val functionButton: Color,
    val functionButtonText: Color,
    val operatorButton: Color,
    val operatorButtonText: Color,
)

val DarkCalculatorColors = CalculatorColors(
    background = CalcBlack,
    displayText = CalcWhite,
    expressionText = CalcLightGray,
    digitButton = CalcDarkGray,
    digitButtonText = CalcWhite,
    functionButton = CalcLightGray,
    functionButtonText = Color.Black,
    operatorButton = CalcOrange,
    operatorButtonText = CalcWhite,
)

val LightCalculatorColors = CalculatorColors(
    background = LightBackground,
    displayText = LightDisplayText,
    expressionText = LightExpressionText,
    digitButton = LightDigitButton,
    digitButtonText = LightDisplayText,
    functionButton = LightFunctionButton,
    functionButtonText = LightDisplayText,
    operatorButton = CalcOrange,
    operatorButtonText = CalcWhite,
)

val LocalCalculatorColors = staticCompositionLocalOf { DarkCalculatorColors }
