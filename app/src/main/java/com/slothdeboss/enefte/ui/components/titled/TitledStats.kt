package com.slothdeboss.enefte.ui.components.titled

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.slothdeboss.enefte.ui.theme.EnEfTeTheme

@Composable
fun TitledStats(
    title: String,
    stats: String,
    modifier: Modifier = Modifier
) {
    val colors = EnEfTeTheme.colors
    val typography = EnEfTeTheme.typography

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(EnEfTeTheme.dimensions.dimension8),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            style = typography.caption.copy(
                color = colors.grayLight
            )
        )

        Text(
            text = stats,
            style = typography.body.copy(
                color = colors.white
            )
        )
    }
}

@Preview
@Composable
private fun Preview() {
    EnEfTeTheme {
        TitledStats(
            title = "Items",
            stats = "10K"
        )
    }
}
