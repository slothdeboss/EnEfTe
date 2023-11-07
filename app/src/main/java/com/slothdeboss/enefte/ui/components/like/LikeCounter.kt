package com.slothdeboss.enefte.ui.components.like

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.slothdeboss.enefte.R
import com.slothdeboss.enefte.ui.theme.EnEfTeTheme

@Composable
fun LikeCounter(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    val colors = EnEfTeTheme.colors
    val dimensions = EnEfTeTheme.dimensions
    val typography = EnEfTeTheme.typography

    Row(
        modifier = modifier.clickable(onClick = onClick),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.size(18.dp),
            painter = painterResource(id = R.drawable.ic_like_empty),
            contentDescription = "Like icon",
            tint = colors.grayLight
        )

        Spacer(modifier = Modifier.width(dimensions.dimension4))

        Text(
            text = stringResource(id = R.string.max_collection_cap),
            style = typography.caption.copy(
                color = colors.grayLight
            )
        )
    }
}

@Preview
@Composable
private fun Preview() {
    EnEfTeTheme {
        LikeCounter()
    }
}
