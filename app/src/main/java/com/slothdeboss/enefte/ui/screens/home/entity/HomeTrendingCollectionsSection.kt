package com.slothdeboss.enefte.ui.screens.home.entity

import com.slothdeboss.enefte.domain.collection.TrendingCollection

data class HomeTrendingCollectionsSection(val collection: List<TrendingCollection>) {
    companion object {
        fun empty() = HomeTrendingCollectionsSection(collection = emptyList())
    }
}
