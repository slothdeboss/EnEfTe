package com.slothdeboss.enefte.di

import com.slothdeboss.enefte.ui.screens.home.providers.FilterTagListProvider
import com.slothdeboss.enefte.ui.screens.home.providers.HomeTagsProvider
import com.slothdeboss.enefte.ui.screens.home.providers.TrendingCollectionsListProvider
import com.slothdeboss.enefte.ui.screens.home.providers.TrendingCollectionsProvider
import com.slothdeboss.enefte.ui.screens.onboarding.providers.EnEfTeOnboardingPageListProvider
import com.slothdeboss.enefte.ui.screens.onboarding.providers.OnboardingPageListProvider
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val DataProvidersModule = module {
    singleOf(::HomeTagsProvider).bind(FilterTagListProvider::class)
    singleOf(::EnEfTeOnboardingPageListProvider).bind(OnboardingPageListProvider::class)
    singleOf(::TrendingCollectionsProvider) bind (TrendingCollectionsListProvider::class)
}
