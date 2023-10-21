package com.slothdeboss.enefte.ui.screens.home.entity

import com.slothdeboss.enefte.domain.listings.TrendingListing

data class HomeTrendingListingsSection(val listings: List<TrendingListing>) {
    companion object {
        fun empty() = HomeTrendingListingsSection(listings = emptyList())
    }
}
