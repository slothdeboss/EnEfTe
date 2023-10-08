package com.slothdeboss.enefte.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

val Dimensions = EnEfTeDimensions(
    dimension2 = 2.dp,
    dimension4 = 4.dp,
    dimension8 = 8.dp,
    dimension12 = 12.dp,
    dimension16 = 16.dp,
    dimension20 = 20.dp,
    dimension24 = 24.dp,
    dimension32 = 32.dp,
    dimension36 = 36.dp,
    dimension40 = 40.dp,
    dimension52 = 52.dp
)

@Immutable
data class EnEfTeDimensions(
    val dimension2: Dp = Dp.Unspecified,
    val dimension4: Dp = Dp.Unspecified,
    val dimension8: Dp = Dp.Unspecified,
    val dimension12: Dp = Dp.Unspecified,
    val dimension16: Dp = Dp.Unspecified,
    val dimension20: Dp = Dp.Unspecified,
    val dimension24: Dp = Dp.Unspecified,
    val dimension32: Dp = Dp.Unspecified,
    val dimension36: Dp = Dp.Unspecified,
    val dimension40: Dp = Dp.Unspecified,
    val dimension52: Dp = Dp.Unspecified
)
