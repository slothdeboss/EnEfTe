package com.slothdeboss.enefte.ui.screens.onboarding.entity

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.runtime.Stable

@Stable
data class OnboardingState(
    val currentPage: Int = 0,
    val pages: List<OnboardingPage> = emptyList()
)

@Stable
data class OnboardingPage(
    @DrawableRes
    val image: Int,
    @StringRes
    val message: Int
)
