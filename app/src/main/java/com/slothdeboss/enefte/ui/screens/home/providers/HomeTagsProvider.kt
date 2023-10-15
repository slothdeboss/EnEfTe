package com.slothdeboss.enefte.ui.screens.home.providers

import com.slothdeboss.enefte.R
import com.slothdeboss.enefte.domain.providers.data.FilterTagListProvider
import com.slothdeboss.enefte.domain.tags.FilterTag
import com.slothdeboss.enefte.ui.util.resources.string.StringArrayResourceProvider

class HomeTagsProvider(
    private val resourceProvider: StringArrayResourceProvider
) : FilterTagListProvider {

    override fun provideData(): List<FilterTag> {
        return resourceProvider.provideResource(R.array.home_filter_tags)
            .mapIndexed { index, tag ->
                FilterTag(
                    title = tag,
                    isSelected = index == INDEX_FIRST
                )
            }
    }

    companion object {
        private const val INDEX_FIRST = 0
    }
}
