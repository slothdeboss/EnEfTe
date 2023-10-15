package com.slothdeboss.enefte.ui.components.balance

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.slothdeboss.enefte.R
import com.slothdeboss.enefte.ui.theme.EnEfTeTheme

@Composable
fun PriceBox(
    value: Double,
    modifier: Modifier = Modifier,
    colors: PriceBoxColors = PriceBoxDefaults.colors(),
    paddings: PriceBoxPaddings = PriceBoxDefaults.paddings(),
    textStyle: TextStyle = EnEfTeTheme.typography.caption,
    onClick: () -> Unit = {}
) {

    val dimensions = EnEfTeTheme.dimensions

    Box(
        modifier = modifier
            .clickable { onClick() }
            .clip(RoundedCornerShape(10.dp))
            .border(color = colors.borderColor, width = 1.dp, shape = RoundedCornerShape(10.dp)),
    ) {
        Row(
            modifier = Modifier
                .wrapContentWidth()
                .padding(
                    horizontal = paddings.horizontal,
                    vertical = paddings.vertical
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(dimensions.dimension12)
        ) {
            Image(
                modifier = modifier.height(dimensions.dimension20),
                painter = painterResource(id = R.drawable.ic_ethereum),
                contentDescription = null
            )

            Text(
                text = value.toString(),
                style = textStyle.copy(color = colors.textColor)
            )

            Text(
                text = stringResource(id = R.string.eth),
                style = textStyle.copy(color = colors.textColor)
            )
        }
    }
}

object PriceBoxDefaults {

    @Composable
    fun colors(
        textColor: Color = EnEfTeTheme.colors.white,
        borderColor: Color = EnEfTeTheme.colors.white,
    ): PriceBoxColors {
        return PriceBoxColors(
            textColor = textColor,
            borderColor = borderColor
        )
    }

    @Composable
    fun paddings(
        horizontal: Dp = EnEfTeTheme.dimensions.dimension12,
        vertical: Dp = EnEfTeTheme.dimensions.dimension8
    ): PriceBoxPaddings {
        return PriceBoxPaddings(
            horizontal = horizontal,
            vertical = vertical
        )
    }
}

data class PriceBoxColors(
    val textColor: Color,
    val borderColor: Color
)

data class PriceBoxPaddings(
    val horizontal: Dp,
    val vertical: Dp
)

@Preview
@Composable
private fun Preview() {
    EnEfTeTheme {
        PriceBox(value = 1.5)
    }
}