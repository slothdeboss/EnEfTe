package com.slothdeboss.enefte.ui.screens.onboarding.event

sealed interface OnboardingEvent {
    data class OnCurrentPageUpdatedEvent(val page: Int) : OnboardingEvent

    data object OnNextOnboardingPageEvent : OnboardingEvent
    data object OnPreviousOnboardingPageEvent : OnboardingEvent
}
