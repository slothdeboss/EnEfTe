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
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.slothdeboss.enefte.R
import com.slothdeboss.enefte.ui.theme.EnEfTeTheme

@Composable
fun ListingItemSmall(
    modifier: Modifier = Modifier
) {
    val colors = EnEfTeTheme.colors
    val shapes = EnEfTeTheme.shapes
    val dimensions = EnEfTeTheme.dimensions
    val typography = EnEfTeTheme.typography

    Column(
        modifier = modifier
            .width(158.dp)
            .height(216.dp)
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
                Row {
                    Text(
                        text = "Karafuru",
                        style = typography.smallCaption.copy(
                            color = colors.grayLight
                        )
                    )

                    Spacer(modifier = Modifier.width(dimensions.dimension4))

                    Image(
                        painter = painterResource(id = R.drawable.ic_verified),
                        contentDescription = "Collection verified"
                    )
                }

                Spacer(modifier = Modifier.height(dimensions.dimension8))

                Text(
                    text = "Otan #2622",
                    style = typography.caption.copy(
                        color = colors.white
                    )
                )
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    modifier = Modifier.size(18.dp),
                    painter = painterResource(id = R.drawable.ic_like_empty),
                    contentDescription = "Like icon",
                    tint = colors.grayLight
                )

                Spacer(modifier = Modifier.width(dimensions.dimension4))

                Text(
                    text = "19",
                    style = typography.caption.copy(
                        color = colors.grayLight
                    )
                )
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    EnEfTeTheme {
        ListingItemSmall()
    }
}
