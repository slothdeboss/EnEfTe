package com.slothdeboss.enefte.domain.listings

import androidx.annotation.DrawableRes

data class TrendingListing(
    val id: Int,
    val category: String,
    @DrawableRes val image: Int,
    val price: Double,
    val collection: ListingCollection,
    val expireDate: String,
    val isLiked: Boolean
)

data class ListingCollection(
    @DrawableRes val image: Int,
    val name: String,
    val isVerified: Boolean
)
