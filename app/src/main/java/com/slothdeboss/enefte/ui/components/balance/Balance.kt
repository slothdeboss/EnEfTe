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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.slothdeboss.enefte.R
import com.slothdeboss.enefte.ui.theme.EnEfTeTheme

@Composable
fun AccountBalance(
    userBalance: Double,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {

    val dimensions = EnEfTeTheme.dimensions
    val typography = EnEfTeTheme.typography
    val colors = EnEfTeTheme.colors

    Box(
        modifier = modifier
            .clickable { onClick() }
            .clip(RoundedCornerShape(10.dp))
            .border(color = colors.white, width = 1.dp, shape = RoundedCornerShape(10.dp)),
    ) {
        Row(
            modifier = Modifier
                .wrapContentWidth()
                .padding(
                    horizontal = dimensions.dimension16,
                    vertical = dimensions.dimension8
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
                text = userBalance.toString(),
                style = typography.button.copy(color = colors.white)
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF15202B)
@Composable
private fun Preview() {
    EnEfTeTheme {
        AccountBalance(userBalance = 266.8)
    }
}