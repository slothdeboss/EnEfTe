package com.slothdeboss.enefte.ui.util.resources.string

import android.content.Context

class EnEfTeStringResourceProvider(
    private val context: Context
) : StringResourceProvider {

    override fun provideResource(id: Int): String {
        return context.getString(id)
    }

    override fun provideResource(id: Int, vararg values: Any): String {
        return context.getString(id, values)
    }
}
