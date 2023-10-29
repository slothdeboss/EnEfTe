package com.slothdeboss.enefte.ui.components.collections

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.slothdeboss.enefte.R
import com.slothdeboss.enefte.ui.components.image.VerifiedProfileImage
import com.slothdeboss.enefte.ui.components.titled.TitledStats
import com.slothdeboss.enefte.ui.theme.EnEfTeTheme

@Composable
fun DiscoverCollectionItem(
    modifier: Modifier = Modifier
) {
    val dimensions = EnEfTeTheme.dimensions
    val typography = EnEfTeTheme.typography
    val colors = EnEfTeTheme.colors

    Column(
        modifier = modifier
            .clip(shape = EnEfTeTheme.shapes.default)
            .background(color = colors.secondary)
            .height(152.dp)
            .width(148.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.dummy_image),
            contentDescription = "Collection banner",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.25f)
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .weight(0.75f)
                .offset(y = (-22).dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            VerifiedProfileImage(
                image = painterResource(id = R.drawable.ic_pfp),
                isVerified = true,
                size = 44.dp,
            )

            Spacer(
                modifier = Modifier.height(dimensions.dimension8)
            )

            Text(
                text = "Name",
                style = typography.caption.copy(
                    color = colors.white
                )
            )

            Spacer(
                modifier = Modifier.height(dimensions.dimension8)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = dimensions.dimension12),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TitledStats(
                    title = stringResource(id = R.string.items),
                    stats = stringResource(id = R.string.max_collection_cap)
                )

                TitledStats(
                    title = stringResource(id = R.string.owners),
                    stats = stringResource(id = R.string.max_collection_cap)
                )
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    EnEfTeTheme {
        DiscoverCollectionItem()
    }
}
