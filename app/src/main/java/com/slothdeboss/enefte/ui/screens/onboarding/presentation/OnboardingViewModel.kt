package com.slothdeboss.enefte.ui.screens.onboarding.presentation

import com.slothdeboss.enefte.domain.navigation.NavigationEffect
import com.slothdeboss.enefte.ui.navigation.OnboardingDestinations
import com.slothdeboss.enefte.ui.screens.base.BaseViewModel
import com.slothdeboss.enefte.ui.screens.onboarding.entity.OnboardingState
import com.slothdeboss.enefte.ui.screens.onboarding.event.OnboardingEvent
import com.slothdeboss.enefte.ui.screens.onboarding.providers.OnboardingPageListProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class OnboardingViewModel(
    private val onboardingPageListProvider: OnboardingPageListProvider
) : BaseViewModel() {

    private val _state = MutableStateFlow(OnboardingState())
    val state = _state.asStateFlow()

    init {
        _state.update { currentState ->
            currentState.copy(
                pages = onboardingPageListProvider.provideData()
            )
        }
    }

    fun onEvent(event: OnboardingEvent) {
        when (event) {
            is OnboardingEvent.OnCurrentPageUpdatedEvent -> onCurrentPageUpdatedEvent(event.page)
            OnboardingEvent.OnNextOnboardingPageEvent -> onNextPageEvent()
            OnboardingEvent.OnPreviousOnboardingPageEvent -> onPreviousPageEvent()
        }
    }

    private fun onCurrentPageUpdatedEvent(page: Int) {
        _state.update { currentState ->
            currentState.copy(currentPage = page)
        }
    }

    private fun onPreviousPageEvent() {
        _state.update { currentState ->
            if (currentState.currentPage > 0) {
                currentState.copy(
                    currentPage = currentState.currentPage - 1
                )
            } else {
                currentState
            }
        }
    }

    private fun onNextPageEvent() {
        _state.update { currentState ->
            if (currentState.currentPage < currentState.pages.lastIndex) {
                currentState.copy(
                    currentPage = currentState.currentPage + 1
                )
            } else {
                emitNavigationEffect(
                    NavigationEffect.NavigateForwardTo(
                        OnboardingDestinations.START
                    )
                )
                currentState
            }
        }
    }
}
