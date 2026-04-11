package org.prauga.pvotcalculator

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.prauga.pvotcalculator.ui.theme.CalcDarkGray
import org.prauga.pvotcalculator.ui.theme.CalcLightGray
import org.prauga.pvotcalculator.ui.theme.CalcOrange
import org.prauga.pvotcalculator.ui.theme.CalcWhite
import org.prauga.pvotcalculator.ui.theme.SoraFamily

// Portrait constants
private val ButtonSpacing = 12.dp
private val KeypadPadding = 12.dp

// Landscape constants
private val LandscapeSpacing = 10.dp
private val LandscapeHPadding = 12.dp
private val LandscapeVPadding = 10.dp

@Composable
fun CalculatorKeypad(
    onDigit: (String) -> Unit,
    onOperator: (String) -> Unit,
    onEquals: () -> Unit,
    onClear: () -> Unit,
    onBackspace: () -> Unit,
    onDecimal: () -> Unit,
    onToggleSign: () -> Unit,
    onPercent: () -> Unit,
    isLandscape: Boolean = false,
    modifier: Modifier = Modifier
) {
    if (isLandscape) {
        LandscapeKeypadLayout(
            onDigit = onDigit,
            onOperator = onOperator,
            onEquals = onEquals,
            onClear = onClear,
            onBackspace = onBackspace,
            onDecimal = onDecimal,
            onToggleSign = onToggleSign,
            onPercent = onPercent,
            modifier = modifier
        )
    } else {
        PortraitKeypadLayout(
            onDigit = onDigit,
            onOperator = onOperator,
            onEquals = onEquals,
            onClear = onClear,
            onDecimal = onDecimal,
            onToggleSign = onToggleSign,
            onPercent = onPercent,
            modifier = modifier
        )
    }
}

// Landscape layout — 5 columns × 4 rows of pill-shaped buttons

@Composable
private fun LandscapeKeypadLayout(
    onDigit: (String) -> Unit,
    onOperator: (String) -> Unit,
    onEquals: () -> Unit,
    onClear: () -> Unit,
    onBackspace: () -> Unit,
    onDecimal: () -> Unit,
    onToggleSign: () -> Unit,
    onPercent: () -> Unit,
    modifier: Modifier = Modifier
) {
    BoxWithConstraints(modifier = modifier) {
        val spacing = LandscapeSpacing
        val hPadding = LandscapeHPadding
        val vPadding = LandscapeVPadding

        // 5 columns, 4 inter-column gaps; 4 rows, 3 inter-row gaps
        val btnWidth = (maxWidth - hPadding * 2 - spacing * 4) / 5
        val btnHeight = (maxHeight - vPadding * 2 - spacing * 3) / 4
        val digitFontSize = 22
        val opFontSize = 26

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = hPadding, vertical = vPadding),
            verticalArrangement = Arrangement.spacedBy(spacing)
        ) {
            // Row 1: 7, 8, 9, ⌫, ÷
            LandscapeRow(spacing) {
                PillButton("7", CalcDarkGray, CalcWhite, btnWidth, btnHeight, digitFontSize) { onDigit("7") }
                PillButton("8", CalcDarkGray, CalcWhite, btnWidth, btnHeight, digitFontSize) { onDigit("8") }
                PillButton("9", CalcDarkGray, CalcWhite, btnWidth, btnHeight, digitFontSize) { onDigit("9") }
                PillButton("⌫", CalcDarkGray, CalcWhite, btnWidth, btnHeight, digitFontSize) { onBackspace() }
                PillButton("÷", CalcOrange, CalcWhite, btnWidth, btnHeight, opFontSize) { onOperator("÷") }
            }
            // Row 2: 4, 5, 6, AC, ×
            LandscapeRow(spacing) {
                PillButton("4", CalcDarkGray, CalcWhite, btnWidth, btnHeight, digitFontSize) { onDigit("4") }
                PillButton("5", CalcDarkGray, CalcWhite, btnWidth, btnHeight, digitFontSize) { onDigit("5") }
                PillButton("6", CalcDarkGray, CalcWhite, btnWidth, btnHeight, digitFontSize) { onDigit("6") }
                PillButton("AC", CalcDarkGray, CalcWhite, btnWidth, btnHeight, fontSize = 18) { onClear() }
                PillButton("×", CalcOrange, CalcWhite, btnWidth, btnHeight, opFontSize) { onOperator("×") }
            }
            // Row 3: 1, 2, 3, %, −
            LandscapeRow(spacing) {
                PillButton("1", CalcDarkGray, CalcWhite, btnWidth, btnHeight, digitFontSize) { onDigit("1") }
                PillButton("2", CalcDarkGray, CalcWhite, btnWidth, btnHeight, digitFontSize) { onDigit("2") }
                PillButton("3", CalcDarkGray, CalcWhite, btnWidth, btnHeight, digitFontSize) { onDigit("3") }
                PillButton("%", CalcDarkGray, CalcWhite, btnWidth, btnHeight, digitFontSize) { onPercent() }
                PillButton("−", CalcOrange, CalcWhite, btnWidth, btnHeight, opFontSize) { onOperator("−") }
            }
            // Row 4: +/−, 0, ., =, +
            LandscapeRow(spacing) {
                PillButton("+/−", CalcDarkGray, CalcWhite, btnWidth, btnHeight, fontSize = 18) { onToggleSign() }
                PillButton("0", CalcDarkGray, CalcWhite, btnWidth, btnHeight, digitFontSize) { onDigit("0") }
                PillButton(".", CalcDarkGray, CalcWhite, btnWidth, btnHeight, digitFontSize) { onDecimal() }
                PillButton("=", CalcOrange, CalcWhite, btnWidth, btnHeight, opFontSize) { onEquals() }
                PillButton("+", CalcOrange, CalcWhite, btnWidth, btnHeight, opFontSize) { onOperator("+") }
            }
        }
    }
}

@Composable
private fun LandscapeRow(
    spacing: Dp,
    content: @Composable RowScope.() -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(spacing),
        content = content
    )
}

/** Stadium/pill-shaped button used in landscape mode. */
@Composable
private fun PillButton(
    text: String,
    containerColor: Color,
    contentColor: Color,
    width: Dp,
    height: Dp,
    fontSize: Int = 22,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .width(width)
            .height(height),
        shape = RoundedCornerShape(height / 2),
        contentPadding = PaddingValues(0.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor
        )
    ) {
        Text(
            text = text,
            fontSize = fontSize.sp,
            fontFamily = SoraFamily,
            fontWeight = FontWeight.Normal,
            maxLines = 1,
        )
    }
}

// Portrait layout — 4 columns × 5 rows of circular buttons (original design)
@Composable
private fun PortraitKeypadLayout(
    onDigit: (String) -> Unit,
    onOperator: (String) -> Unit,
    onEquals: () -> Unit,
    onClear: () -> Unit,
    onDecimal: () -> Unit,
    onToggleSign: () -> Unit,
    onPercent: () -> Unit,
    modifier: Modifier = Modifier
) {
    BoxWithConstraints(modifier = modifier) {
        val spacing = ButtonSpacing
        val hPadding = KeypadPadding

        // Button size fits 4 circles across the available width
        val buttonSize = (maxWidth - hPadding * 2 - spacing * 3) / 4

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = hPadding, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(spacing)
        ) {
            // Row 1: AC, +/−, %, ÷
            PortraitRow(spacing) {
                CalcButton("AC", CalcLightGray, Color.Black, buttonSize, fontSize = 20) { onClear() }
                CalcButton("+/−", CalcLightGray, Color.Black, buttonSize, fontSize = 18) { onToggleSign() }
                CalcButton("%", CalcLightGray, Color.Black, buttonSize) { onPercent() }
                CalcButton("÷", CalcOrange, CalcWhite, buttonSize, fontSize = 30) { onOperator("÷") }
            }
            // Row 2: 7, 8, 9, ×
            PortraitRow(spacing) {
                CalcButton("7", CalcDarkGray, CalcWhite, buttonSize) { onDigit("7") }
                CalcButton("8", CalcDarkGray, CalcWhite, buttonSize) { onDigit("8") }
                CalcButton("9", CalcDarkGray, CalcWhite, buttonSize) { onDigit("9") }
                CalcButton("×", CalcOrange, CalcWhite, buttonSize, fontSize = 30) { onOperator("×") }
            }
            // Row 3: 4, 5, 6, −
            PortraitRow(spacing) {
                CalcButton("4", CalcDarkGray, CalcWhite, buttonSize) { onDigit("4") }
                CalcButton("5", CalcDarkGray, CalcWhite, buttonSize) { onDigit("5") }
                CalcButton("6", CalcDarkGray, CalcWhite, buttonSize) { onDigit("6") }
                CalcButton("−", CalcOrange, CalcWhite, buttonSize, fontSize = 30) { onOperator("−") }
            }
            // Row 4: 1, 2, 3, +
            PortraitRow(spacing) {
                CalcButton("1", CalcDarkGray, CalcWhite, buttonSize) { onDigit("1") }
                CalcButton("2", CalcDarkGray, CalcWhite, buttonSize) { onDigit("2") }
                CalcButton("3", CalcDarkGray, CalcWhite, buttonSize) { onDigit("3") }
                CalcButton("+", CalcOrange, CalcWhite, buttonSize, fontSize = 30) { onOperator("+") }
            }
            // Row 5: 0 (wide), ., =
            PortraitRow(spacing) {
                WideCalcButton("0", CalcDarkGray, CalcWhite, buttonSize, spacing) { onDigit("0") }
                CalcButton(".", CalcDarkGray, CalcWhite, buttonSize) { onDecimal() }
                CalcButton("=", CalcOrange, CalcWhite, buttonSize, fontSize = 30) { onEquals() }
            }
        }
    }
}

@Composable
private fun PortraitRow(
    spacing: Dp,
    content: @Composable RowScope.() -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(spacing),
        content = content
    )
}

/** Circular button used in portrait mode. */
@Composable
private fun CalcButton(
    text: String,
    containerColor: Color,
    contentColor: Color,
    buttonSize: Dp,
    fontSize: Int = 26,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier.size(buttonSize),
        shape = CircleShape,
        contentPadding = PaddingValues(0.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor
        )
    ) {
        Text(
            text = text,
            fontSize = fontSize.sp,
            fontFamily = SoraFamily,
            fontWeight = FontWeight.Normal,
            maxLines = 1,
        )
    }
}

/**
 * Double-wide "0" button in portrait mode.
 * Width = buttonSize * 2 + spacing — exactly two button slots plus their gap,
 * so the last row fills perfectly with zero overflow.
 */
@Composable
private fun WideCalcButton(
    text: String,
    containerColor: Color,
    contentColor: Color,
    buttonSize: Dp,
    spacing: Dp,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .height(buttonSize)
            .width(buttonSize * 2 + spacing),
        shape = RoundedCornerShape(buttonSize / 2),
        contentPadding = PaddingValues(horizontal = buttonSize * 0.3f, vertical = 0.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor
        )
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = text,
                fontSize = 26.sp,
                fontFamily = SoraFamily,
                fontWeight = FontWeight.Normal,
                maxLines = 1,
            )
        }
    }
}
