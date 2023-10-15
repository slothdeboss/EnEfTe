package com.slothdeboss.enefte.ui.screens.home.entity

import com.slothdeboss.enefte.domain.tags.FilterTag

data class HomeTagsSection(val tags: List<FilterTag>) {

    companion object {

        fun empty() = HomeTagsSection(tags = emptyList())
    }
}
