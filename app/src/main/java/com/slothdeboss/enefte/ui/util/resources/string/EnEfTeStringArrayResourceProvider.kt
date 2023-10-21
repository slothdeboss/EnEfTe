package com.slothdeboss.enefte.ui.util.resources.string

import android.content.Context

class EnEfTeStringArrayResourceProvider(
    private val context: Context
) : StringArrayResourceProvider {

    override fun provideResource(id: Int): List<String> {
        return context.resources.getStringArray(id).toList()
    }
}
