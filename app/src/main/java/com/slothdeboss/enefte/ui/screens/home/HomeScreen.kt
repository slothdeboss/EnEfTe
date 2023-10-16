package com.slothdeboss.enefte.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.slothdeboss.enefte.domain.collection.TrendingCollection
import com.slothdeboss.enefte.domain.listings.TrendingListing
import com.slothdeboss.enefte.ui.components.collections.TrendingCollectionsList
import com.slothdeboss.enefte.ui.components.listing.TrendingListingsBar
import com.slothdeboss.enefte.ui.components.tag.FilterTagsBar
import com.slothdeboss.enefte.ui.components.topAppBar.HomeTopAppBar
import com.slothdeboss.enefte.ui.screens.home.entity.HomeState
import com.slothdeboss.enefte.ui.theme.EnEfTeTheme

@Composable
fun HomeScreen(state: HomeState) {

    val colors = EnEfTeTheme.colors
    val dimensions = EnEfTeTheme.dimensions

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = colors.dark,
        topBar = {
            HomeTopAppBar(
                onProfilePictureClick = {}
            )
        }
    ) { parentPadding ->
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .padding(parentPadding)
        ) {
            FilterTagsBar(
                tags = state.tagsSection.tags,
                onTagClick = {},
                state = rememberLazyListState(),
                contentPadding = PaddingValues(
                    horizontal = dimensions.dimension24,
                    vertical = dimensions.dimension16
                )
            )

            // TODO - add proper listings list later and snap effect
            TrendingListingsBar(
                listings = listOf(
                    TrendingListing.default(),
                    TrendingListing.default(),
                    TrendingListing.default()
                ),
                onItemClick = {},
                state = rememberLazyListState(),
                contentPadding = PaddingValues(
                    horizontal = dimensions.dimension24,
                    vertical = dimensions.dimension16
                )
            )

            TrendingCollectionsList(
                collections = listOf(
                    TrendingCollection.create(increased = true),
                    TrendingCollection.create(increased = false),
                    TrendingCollection.create(increased = false),
                    TrendingCollection.create(increased = true),
                    TrendingCollection.create(increased = true),
                ),
                onItemClick = {},
                contentPadding = PaddingValues(
                    horizontal = dimensions.dimension24,
                    vertical = dimensions.dimension12
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    EnEfTeTheme {
        HomeScreen(state = HomeState.default())
    }
}
