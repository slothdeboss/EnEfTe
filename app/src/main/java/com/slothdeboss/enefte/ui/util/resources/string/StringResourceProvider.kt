package com.slothdeboss.enefte.ui.util.resources.string

import androidx.annotation.StringRes
import com.slothdeboss.enefte.domain.providers.resource.ResourceProvider

interface StringResourceProvider : ResourceProvider<String> {

    override fun provideResource(@StringRes id: Int): String
    fun provideResource(@StringRes id: Int, vararg values: Any): String
}
