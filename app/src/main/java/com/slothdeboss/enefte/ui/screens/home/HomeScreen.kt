package com.slothdeboss.enefte.ui.screens.home

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.slothdeboss.enefte.domain.listings.TrendingListing
import com.slothdeboss.enefte.ui.components.listing.TrendingListingsBar
import com.slothdeboss.enefte.ui.components.tag.FilterTagsBar
import com.slothdeboss.enefte.ui.components.topAppBar.HomeTopAppBar
import com.slothdeboss.enefte.ui.screens.home.entity.HomeState
import com.slothdeboss.enefte.ui.theme.EnEfTeTheme

@Composable
fun HomeScreen(
    state: HomeState
) {

    val colors = EnEfTeTheme.colors
    val typography = EnEfTeTheme.typography
    val dimensions = EnEfTeTheme.dimensions

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = colors.dark,
        topBar = {
            HomeTopAppBar(
                modifier = Modifier.padding(vertical = dimensions.dimension8),
                onProfilePictureClick = {}
            )
        }
    ) { parentPadding ->
        Column(
            modifier = Modifier
                .scrollable(
                    state = rememberScrollState(),
                    orientation = Orientation.Vertical
                )
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
                    vertical = dimensions.dimension8
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
