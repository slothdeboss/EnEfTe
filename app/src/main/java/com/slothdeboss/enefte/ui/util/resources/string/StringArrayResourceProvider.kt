package com.slothdeboss.enefte.ui.util.resources.string

import androidx.annotation.ArrayRes
import com.slothdeboss.enefte.domain.providers.resource.ResourceProvider

interface StringArrayResourceProvider : ResourceProvider<List<String>> {
    override fun provideResource(@ArrayRes id: Int): List<String>
}
