package com.slothdeboss.enefte.ui.screens.home.entity

data class HomeState(
    val tagsSection: HomeTagsSection,
    val listingsSection: HomeTrendingListingsSection,
    val collectionsSection: HomeTrendingCollectionsSection
) {

    companion object {

        fun default() = HomeState(
            tagsSection = HomeTagsSection.empty(),
            listingsSection = HomeTrendingListingsSection.empty(),
            collectionsSection = HomeTrendingCollectionsSection.empty()
        )
    }
}
