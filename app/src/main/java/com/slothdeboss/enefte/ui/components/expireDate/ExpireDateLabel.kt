package com.slothdeboss.enefte.ui.components.expireDate

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.slothdeboss.enefte.R
import com.slothdeboss.enefte.ui.theme.EnEfTeTheme

@Composable
fun ExpireDateLabel(
    daysLeft: Int,
    modifier: Modifier = Modifier,
) {
    val dimensions = EnEfTeTheme.dimensions
    val typography = EnEfTeTheme.typography
    val colors = EnEfTeTheme.colors

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(dimensions.dimension4),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(painter = painterResource(
            id = R.drawable.ic_time),
            contentDescription = null,
            tint = colors.grayLight
        )

        Text(
            text = stringResource(id = R.string.days_left, daysLeft),
            style = typography.caption.copy(color = colors.grayLight)
        )
    }
}

@Preview
@Composable
private fun Preview() {
    EnEfTeTheme {
        ExpireDateLabel(
            daysLeft = 10
        )
    }
}
