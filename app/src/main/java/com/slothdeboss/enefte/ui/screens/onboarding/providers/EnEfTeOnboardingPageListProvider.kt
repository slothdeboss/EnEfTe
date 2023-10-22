package com.slothdeboss.enefte.ui.screens.onboarding.providers

import com.slothdeboss.enefte.R
import com.slothdeboss.enefte.ui.screens.onboarding.entity.OnboardingPage

class EnEfTeOnboardingPageListProvider : OnboardingPageListProvider {
    override fun provideData(): List<OnboardingPage> {
        return listOf(
            OnboardingPage(
                image = R.drawable.tokens,
                message = R.string.discover_largest_marketplace
            ),
            OnboardingPage(
                image = R.drawable.pfp_with_token,
                message = R.string.start_your_own_nft_gallery
            ),
            OnboardingPage(
                image = R.drawable.search_nft,
                message = R.string.discovering_the_world_of_crypto_art
            )
        )
    }
}