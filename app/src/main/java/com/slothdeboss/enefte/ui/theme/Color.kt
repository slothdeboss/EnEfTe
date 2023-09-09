package com.slothdeboss.enefte.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

val Colors = EnEfTeColorPalette(
    primary = Color(0xFF1D9BF0),
    secondary = Color(0xFF253341),
    success = Color(0xFF00CBB3),
    danger = Color(0xFFEB5757),
    dark = Color(0xFF15202B),
    grayLight = Color(0xFFAAB8C2),
    white = Color(0xFFF5F8FA)
)

@Immutable
class EnEfTeColorPalette(
    val primary: Color = Color.Unspecified,
    val secondary: Color = Color.Unspecified,
    val success: Color = Color.Unspecified,
    val danger: Color = Color.Unspecified,
    val dark: Color = Color.Unspecified,
    val grayLight: Color = Color.Unspecified,
    val white: Color = Color.Unspecified,
)
