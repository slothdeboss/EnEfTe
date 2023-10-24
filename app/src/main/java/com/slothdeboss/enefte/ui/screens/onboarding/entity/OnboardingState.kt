package com.slothdeboss.enefte.ui.screens.onboarding.entity

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.runtime.Immutable

@Immutable
data class OnboardingState(
    val currentPage: Int = 0,
    val pages: List<OnboardingPage> = emptyList()
)

@Immutable
data class OnboardingPage(
    @DrawableRes
    val image: Int,
    @StringRes
    val message: Int
)
