package com.slothdeboss.enefte.di

import com.slothdeboss.enefte.domain.providers.data.FilterTagListProvider
import com.slothdeboss.enefte.ui.screens.home.providers.HomeTagsProvider
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val DataProvidersModule = module {
    singleOf(::HomeTagsProvider).bind(FilterTagListProvider::class)
}
