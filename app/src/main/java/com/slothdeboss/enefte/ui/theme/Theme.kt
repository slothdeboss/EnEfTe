package com.slothdeboss.enefte.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable

@Composable
fun EnEfTeTheme(
    content: @Composable () -> Unit
) {

    CompositionLocalProvider(
        LocalColors provides Colors,
        LocalTypography provides Typography,
        content = content
    )
}

object EnEfTeTheme {

    val typography: EnEfTeTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current

    val colors: EnEfTeColorPalette
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current

}
