package com.slothdeboss.enefte.domain.listings

import androidx.annotation.DrawableRes
import com.slothdeboss.enefte.R

data class TrendingListing(
    val id: Int,
    val category: String,
    @DrawableRes val image: Int,
    val price: Double,
    val collection: ListingCollection,
    val expireDate: String,
    val isLiked: Boolean
) {

    companion object {

        // TODO - remove this method after trending listings list implementation
        fun default(): TrendingListing {
            return TrendingListing(
                id = 0,
                category = "Art",
                image = R.drawable.dummy_image,
                price = 22.2,
                collection = ListingCollection(
                    image = R.drawable.ic_ethereum,
                    name = "Something",
                    isVerified = false
                ),
                expireDate = "",
                isLiked = false
            )
        }
    }
}

data class ListingCollection(
    @DrawableRes val image: Int,
    val name: String,
    val isVerified: Boolean
)
