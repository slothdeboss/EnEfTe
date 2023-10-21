package com.slothdeboss.enefte.ui.components.collections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.slothdeboss.enefte.R
import com.slothdeboss.enefte.domain.collection.TrendingCollection
import com.slothdeboss.enefte.ui.theme.EnEfTeTheme

// TODO - refactor to find a better solution to use it as a nested lazy column
@Composable
fun TrendingCollectionsList(
    collections: List<TrendingCollection>,
    onItemClick: (item: TrendingCollection) -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues()
) {
    val colors = EnEfTeTheme.colors
    val typography = EnEfTeTheme.typography

    Column(
        modifier = modifier.padding(contentPadding),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = stringResource(id = R.string.trending_collections),
            style = typography.h2.copy(color = colors.white)
        )
        collections.forEach {
            TrendingCollectionItem(
                collection = it,
                onItemClick = onItemClick
            )
        }
    }
}

@Preview
@Composable
private fun Preview() {
    EnEfTeTheme {
        TrendingCollectionsList(
            collections = listOf(),
            onItemClick = {}
        )
    }
}
