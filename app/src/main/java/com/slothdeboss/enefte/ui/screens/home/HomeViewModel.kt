package com.slothdeboss.enefte.ui.screens.home

import com.slothdeboss.enefte.domain.providers.data.FilterTagListProvider
import com.slothdeboss.enefte.ui.screens.base.BaseViewModel
import com.slothdeboss.enefte.ui.screens.home.entity.HomeState
import com.slothdeboss.enefte.ui.screens.home.entity.HomeTagsSection
import com.slothdeboss.enefte.ui.screens.home.entity.HomeTrendingCollectionsSection
import com.slothdeboss.enefte.ui.screens.home.entity.HomeTrendingListingsSection
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel(
    private val filterTagListProvider: FilterTagListProvider
) : BaseViewModel() {

    private val _state = MutableStateFlow(HomeState.default())
    val state = _state.asStateFlow()

    init {
        _state.value = HomeState(
            tagsSection = HomeTagsSection(tags = filterTagListProvider.provideData()),
            listingsSection = HomeTrendingListingsSection(listOf()),
            collectionsSection = HomeTrendingCollectionsSection(listOf())
        )
    }
}
