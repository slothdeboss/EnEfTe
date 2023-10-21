package com.slothdeboss.enefte.domain.providers.resource

interface ResourceProvider<T> {
    fun provideResource(id: Int) : T
}
