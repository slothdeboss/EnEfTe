package com.slothdeboss.enefte.ui.screens.home.providers

import com.slothdeboss.enefte.domain.collection.TrendingCollection

// TODO - remove later and create repository and use case to interact with collections data
class TrendingCollectionsProvider : TrendingCollectionsListProvider {

    override fun provideData(): List<TrendingCollection> {
        return listOf(
            TrendingCollection.create(increased = true),
            TrendingCollection.create(increased = false),
            TrendingCollection.create(increased = false),
            TrendingCollection.create(increased = true),
            TrendingCollection.create(increased = true),
        )
    }
}
