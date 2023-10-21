package com.slothdeboss.enefte.ui.components.collections

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.slothdeboss.enefte.R
import com.slothdeboss.enefte.domain.collection.TrendingCollection
import com.slothdeboss.enefte.ui.theme.EnEfTeTheme

// TODO - refactor into smaller components
@Composable
fun TrendingCollectionItem(
    collection: TrendingCollection,
    onItemClick: (item: TrendingCollection) -> Unit,
    modifier: Modifier = Modifier
) {
    val dimensions = EnEfTeTheme.dimensions
    val typography = EnEfTeTheme.typography
    val colors = EnEfTeTheme.colors

    Row(
        modifier = modifier
            .clickable { onItemClick(collection) }
            .fillMaxWidth()
            .height(66.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = collection.image),
            contentDescription = null
        )

        Spacer(modifier = Modifier.width(dimensions.dimension24))

        Column(
            verticalArrangement = Arrangement.spacedBy(dimensions.dimension4)
        ) {
            Text(
                text = collection.name,
                style = typography.body.copy(color = colors.white)
            )

            Text(
                text = collection.creatorName,
                style = typography.caption.copy(color = colors.grayLight)
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Column(
            verticalArrangement = Arrangement.spacedBy(dimensions.dimension8),
            horizontalAlignment = Alignment.End
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(dimensions.dimension8),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_ethereum),
                    contentDescription = null
                )

                Text(
                    text = stringResource(id = R.string.eth_template, collection.volume.toString()),
                    style = typography.button.copy(color = colors.white)
                )
            }

            val volumeTemplate by remember(collection) {
                derivedStateOf {
                    if (collection.volumeChange.increased()) {
                        R.string.increased_volume
                    } else {
                        R.string.decreased_volume
                    }
                }
            }

            val volumeColor by remember(collection) {
                derivedStateOf {
                    if (collection.volumeChange.increased()) {
                        colors.success
                    } else {
                        colors.danger
                    }
                }
            }

            Text(
                text = stringResource(id = volumeTemplate, collection.volumeChange.percentage.toString()),
                style = typography.caption.copy(color = volumeColor)
            )
        }
    }
}

@Preview
@Composable
private fun Preview() {
    EnEfTeTheme {
        Surface(color = EnEfTeTheme.colors.dark) {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                TrendingCollectionItem(
                    collection = TrendingCollection.create(increased = false),
                    onItemClick = {}
                )

                TrendingCollectionItem(
                    collection = TrendingCollection.create(increased = true),
                    onItemClick = {}
                )
            }
        }
    }
}
