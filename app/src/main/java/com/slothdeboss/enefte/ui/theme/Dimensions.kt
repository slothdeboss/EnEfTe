package com.slothdeboss.enefte.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

val Dimensions = EnEfTeDimensions(
    xSmall = 4.dp,
    small = 8.dp,
    medium = 12.dp,
    default = 16.dp,
    large = 20.dp,
    xLarge = 24.dp,
    xxLarge = 32.dp,
    xxxLarge = 40.dp
)

@Immutable
data class EnEfTeDimensions(
    val xSmall: Dp = Dp.Unspecified,
    val small: Dp = Dp.Unspecified,
    val medium: Dp = Dp.Unspecified,
    val default: Dp = Dp.Unspecified,
    val large: Dp = Dp.Unspecified,
    val xLarge: Dp = Dp.Unspecified,
    val xxLarge: Dp = Dp.Unspecified,
    val xxxLarge: Dp = Dp.Unspecified
)
