package org.prauga.pvotcalculator.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import com.prauga.pvot.designsystem.theme.PvotBackgroundDark
import com.prauga.pvot.designsystem.theme.PvotBackgroundLight
import com.prauga.pvot.designsystem.theme.PvotOnBackgroundDark
import com.prauga.pvot.designsystem.theme.PvotOnBackgroundLight
import com.prauga.pvot.designsystem.theme.PvotOnPrimaryLight
import com.prauga.pvot.designsystem.theme.PvotOnSecondaryContainerDark
import com.prauga.pvot.designsystem.theme.PvotOnSecondaryContainerLight
import com.prauga.pvot.designsystem.theme.PvotOnSurfaceDark
import com.prauga.pvot.designsystem.theme.PvotOnSurfaceVariantDark
import com.prauga.pvot.designsystem.theme.PvotOnSurfaceVariantLight
import com.prauga.pvot.designsystem.theme.PvotSecondaryContainerDark
import com.prauga.pvot.designsystem.theme.PvotSecondaryContainerLight
import com.prauga.pvot.designsystem.theme.PvotSurfaceVariantDark
import com.prauga.pvot.designsystem.theme.PvotSurfaceVariantLight

/**
 * Semantic color tokens for the calculator UI.
 * Consuming composables read from [LocalCalculatorColors] — they never reference
 * raw color constants directly, which keeps dark/light switching transparent.
 *
 * Raw palette values are sourced from PvotLib's design-system color tokens.
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
    background = PvotBackgroundDark,               // #000000
    displayText = PvotOnBackgroundDark,            // #E6E1E6
    expressionText = PvotOnSurfaceVariantDark,     // #CAC4CF
    digitButton = PvotSurfaceVariantDark,          // #49454E
    digitButtonText = PvotOnSurfaceDark,           // #E6E1E6
    functionButton = PvotSecondaryContainerDark,   // #494458
    functionButtonText = PvotOnSecondaryContainerDark, // #E6DFF9
    operatorButton = CalcOrange,                   // #FF9F0A — brand accent, no PvotLib equiv
    operatorButtonText = PvotOnPrimaryLight,       // #FFFFFF
)

val LightCalculatorColors = CalculatorColors(
    background = PvotBackgroundLight,                  // #FFFFFF
    displayText = PvotOnBackgroundLight,               // #1C1B1F
    expressionText = PvotOnSurfaceVariantLight,        // #49454E
    digitButton = PvotSurfaceVariantLight,             // #E7E0EC — tinted, visible on white bg
    digitButtonText = PvotOnSurfaceVariantLight,       // #49454E
    functionButton = PvotSecondaryContainerLight,      // #E6DFF9 — distinct from digit buttons
    functionButtonText = PvotOnSecondaryContainerLight, // #1C192B
    operatorButton = CalcOrange,                       // #FF9F0A
    operatorButtonText = PvotOnPrimaryLight,           // #FFFFFF
)

val LocalCalculatorColors = staticCompositionLocalOf { DarkCalculatorColors }
