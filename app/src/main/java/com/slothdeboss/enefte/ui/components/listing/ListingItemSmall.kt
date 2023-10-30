package com.slothdeboss.enefte.ui.components.listing

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.slothdeboss.enefte.R
import com.slothdeboss.enefte.ui.components.collections.CollectionLabel
import com.slothdeboss.enefte.ui.components.like.LikeCounter
import com.slothdeboss.enefte.ui.theme.EnEfTeTheme

@Composable
fun ListingItemSmall(
    modifier: Modifier = Modifier,
    size: DpSize = ListingItemDefaults.sizeSmall()
) {
    val colors = EnEfTeTheme.colors
    val shapes = EnEfTeTheme.shapes
    val dimensions = EnEfTeTheme.dimensions
    val typography = EnEfTeTheme.typography

    Column(
        modifier = modifier
            .size(width = size.width, height = size.height)
            .clip(shapes.default)
            .background(color = colors.secondary)
            .padding(dimensions.dimension12),
    ) {
        Image(
            painter = painterResource(id = R.drawable.dummy_nft),
            contentDescription = "Listing image",
            modifier = Modifier
                .weight(0.75f)
                .clip(shapes.default),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(dimensions.dimension12))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                CollectionLabel(
                    isVerified = true
                )

                Spacer(modifier = Modifier.height(dimensions.dimension8))

                Text(
                    text = "Otan #2622", // remove when add some data
                    style = typography.caption.copy(
                        color = colors.white
                    )
                )
            }

            LikeCounter()
        }
    }
}

object ListingItemDefaults {

    fun sizeSmall(
        height: Dp = 216.dp,
        width: Dp = 158.dp
    ): DpSize {
        return DpSize(
            height = height,
            width = width
        )
    }
}

@Preview
@Composable
private fun Preview() {
    EnEfTeTheme {
        ListingItemSmall()
    }
}
