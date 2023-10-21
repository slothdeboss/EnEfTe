package com.slothdeboss.enefte.domain.providers.data

interface DataProvider<T> {
    fun provideData(): T
}
