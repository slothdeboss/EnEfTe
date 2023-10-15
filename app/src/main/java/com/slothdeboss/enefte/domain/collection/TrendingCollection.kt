package com.slothdeboss.enefte.domain.collection

import androidx.annotation.DrawableRes

data class TrendingCollection(
    @DrawableRes val image: Int,
    val name: String,
    val creatorName: String,
    val volume: Double,
    val volumeChange: VolumeChange
)

data class VolumeChange(
    val percentage: Double,
    val type: Type
) {

    enum class Type {
        INCREASED, DECREASED
    }
}