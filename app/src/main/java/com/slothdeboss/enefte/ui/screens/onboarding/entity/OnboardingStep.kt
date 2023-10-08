package com.slothdeboss.enefte.ui.screens.onboarding.entity

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.slothdeboss.enefte.R

enum class OnboardingStep {
    DISCOVER_MARKETPLACE,
    CREATE_GALLERY,
    DISCOVER_WORLD_OF_ART;

    @DrawableRes
    fun getImage(): Int {
        return when (this) {
            DISCOVER_MARKETPLACE -> R.drawable.tokens
            CREATE_GALLERY -> R.drawable.pfp_with_token
            DISCOVER_WORLD_OF_ART -> R.drawable.search_nft
        }
    }

    @StringRes
    fun getStepTitle(): Int {
        return when (this) {
            DISCOVER_MARKETPLACE -> R.string.discover_largest_marketplace
            CREATE_GALLERY -> R.string.start_your_own_nft_gallery
            DISCOVER_WORLD_OF_ART -> R.string.discovering_the_world_of_crypto_art
        }
    }
}
