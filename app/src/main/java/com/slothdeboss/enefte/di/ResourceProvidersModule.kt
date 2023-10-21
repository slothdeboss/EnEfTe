package com.slothdeboss.enefte.di

import com.slothdeboss.enefte.ui.util.resources.string.EnEfTeStringArrayResourceProvider
import com.slothdeboss.enefte.ui.util.resources.string.EnEfTeStringResourceProvider
import com.slothdeboss.enefte.ui.util.resources.string.StringArrayResourceProvider
import com.slothdeboss.enefte.ui.util.resources.string.StringResourceProvider
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val ResourceProvidersModule = module {
    singleOf(::EnEfTeStringResourceProvider).bind(StringResourceProvider::class)
    singleOf(::EnEfTeStringArrayResourceProvider).bind(StringArrayResourceProvider::class)
}
