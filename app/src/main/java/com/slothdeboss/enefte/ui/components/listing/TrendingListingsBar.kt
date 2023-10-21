package com.slothdeboss.enefte.ui.components.listing

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.slothdeboss.enefte.domain.listings.TrendingListing
import com.slothdeboss.enefte.ui.theme.EnEfTeTheme

@Composable
fun TrendingListingsBar(
    listings: List<TrendingListing>,
    onItemClick: (item: TrendingListing) -> Unit,
    state: LazyListState,
    modifier: Modifier = Modifier,
    spaceBy: Dp = EnEfTeTheme.dimensions.dimension16,
    contentPadding: PaddingValues = PaddingValues()
) {
    LazyRow(
        modifier = modifier,
        state = state,
        horizontalArrangement = Arrangement.spacedBy(spaceBy),
        contentPadding = contentPadding
    ) {
        items(items = listings) { item ->
            TrendingListingItem(
                listing = item,
                onItemClick = onItemClick
            )
        }
    }

}

@Preview
@Composable
private fun Preview() {
    EnEfTeTheme {
        TrendingListingsBar(
            listings = listOf(),
            onItemClick = {},
            state = rememberLazyListState()
        )
    }
}
