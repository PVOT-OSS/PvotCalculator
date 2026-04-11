package org.prauga.pvotcalculator

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import org.prauga.pvotcalculator.ui.theme.LocalCalculatorColors
import org.prauga.pvotcalculator.ui.theme.SoraFamily

@Composable
fun CalculatorScreen(
    modifier: Modifier = Modifier,
    viewModel: CalculatorViewModel = viewModel()
) {
    val colors = LocalCalculatorColors.current
    val isLandscape = LocalConfiguration.current.orientation == Configuration.ORIENTATION_LANDSCAPE

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(colors.background)
    ) {
        if (isLandscape) {
            // Landscape: compact display in top-right corner, full-width keypad below
            CalculatorDisplay(
                expression = viewModel.expression,
                display = viewModel.display,
                isLandscape = true,
                modifier = Modifier.fillMaxWidth()
            )
            CalculatorKeypad(
                onDigit = viewModel::onDigit,
                onOperator = viewModel::onOperator,
                onEquals = viewModel::onEquals,
                onClear = viewModel::onClear,
                onBackspace = viewModel::onBackspace,
                onDecimal = viewModel::onDecimal,
                onToggleSign = viewModel::onToggleSign,
                onPercent = viewModel::onPercent,
                isLandscape = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            )
        } else {
            // Portrait: display expands to fill space above keypad
            CalculatorDisplay(
                expression = viewModel.expression,
                display = viewModel.display,
                isLandscape = false,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            )
            CalculatorKeypad(
                onDigit = viewModel::onDigit,
                onOperator = viewModel::onOperator,
                onEquals = viewModel::onEquals,
                onClear = viewModel::onClear,
                onBackspace = viewModel::onBackspace,
                onDecimal = viewModel::onDecimal,
                onToggleSign = viewModel::onToggleSign,
                onPercent = viewModel::onPercent,
                isLandscape = false,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
private fun CalculatorDisplay(
    expression: String,
    display: String,
    isLandscape: Boolean,
    modifier: Modifier = Modifier
) {
    val colors = LocalCalculatorColors.current

    if (isLandscape) {
        // Two lines always rendered so the keyboard position never shifts
        Column(
            modifier = modifier.padding(horizontal = 16.dp, vertical = 4.dp),
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Text(
                text = expression,
                fontSize = 12.sp,
                fontFamily = SoraFamily,
                fontWeight = FontWeight.Light,
                color = colors.expressionText,
                textAlign = TextAlign.End,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = display,
                fontSize = 34.sp,
                fontFamily = SoraFamily,
                fontWeight = FontWeight.Thin,
                color = colors.displayText,
                textAlign = TextAlign.End,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.fillMaxWidth()
            )
        }
    } else {
        // Portrait: bottom-aligned display with larger fonts
        Column(
            modifier = modifier.padding(horizontal = 24.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.End
        ) {
            if (expression.isNotEmpty()) {
                Text(
                    text = expression,
                    fontSize = 24.sp,
                    fontFamily = SoraFamily,
                    fontWeight = FontWeight.Light,
                    color = colors.expressionText,
                    textAlign = TextAlign.End,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                )
            }
            Text(
                text = display,
                fontSize = 80.sp,
                fontFamily = SoraFamily,
                fontWeight = FontWeight.Thin,
                color = colors.displayText,
                textAlign = TextAlign.End,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
