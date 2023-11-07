package com.slothdeboss.enefte.ui.components.collections

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.slothdeboss.enefte.R
import com.slothdeboss.enefte.ui.theme.EnEfTeTheme

@Composable
fun CollectionLabel(
    isVerified: Boolean,
    modifier: Modifier = Modifier,
    onClick: (id: String) -> Unit = {}
) {
    val typography = EnEfTeTheme.typography
    val colors = EnEfTeTheme.colors
    val dimensions = EnEfTeTheme.dimensions

    Row(
        modifier = modifier.clickable { onClick("") }
    ) {
        Text(
            text = "Karafuru",
            style = typography.smallCaption.copy(
                color = colors.grayLight
            )
        )

        if (isVerified) {
            Spacer(modifier = Modifier.width(dimensions.dimension4))

            Image(
                painter = painterResource(id = R.drawable.ic_verified),
                contentDescription = "Collection verified"
            )
        }
    }
}

@Preview
@Composable
private fun Preview() {
    EnEfTeTheme {
        CollectionLabel(
            isVerified = true
        )
    }
}
