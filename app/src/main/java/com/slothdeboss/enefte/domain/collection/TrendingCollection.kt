package com.slothdeboss.enefte.domain.collection

import androidx.annotation.DrawableRes
import com.slothdeboss.enefte.R

data class TrendingCollection(
    @DrawableRes val image: Int,
    val name: String,
    val creatorName: String,
    val volume: Double,
    val volumeChange: VolumeChange
) {

    companion object {

        fun create(increased: Boolean): TrendingCollection {
            return TrendingCollection(
                image = R.drawable.ic_pfp,
                name = "Some trending",
                creatorName = "Bob Lob",
                volume = 345.5,
                volumeChange = VolumeChange(
                    percentage = 25.0,
                    type = if (increased) VolumeChange.Type.INCREASED else VolumeChange.Type.DECREASED
                )
            )
        }
    }
}

data class VolumeChange(
    val percentage: Double,
    val type: Type
) {

    fun increased() = type == Type.INCREASED
    fun decreased() = type == Type.DECREASED

    enum class Type {
        INCREASED, DECREASED
    }
}