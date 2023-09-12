package com.slothdeboss.enefte.ui.screens.onboarding.presentation

import androidx.lifecycle.ViewModel
import com.slothdeboss.enefte.ui.screens.onboarding.entity.OnboardingStep
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class OnboardingViewModel : ViewModel() {

    private val _onboardingStep = MutableStateFlow(OnboardingStep.DISCOVER_MARKETPLACE)
    val onboardingStep = _onboardingStep.asStateFlow()

    private val _shouldNavigateForward = MutableStateFlow(Unit)
    val shouldNavigateForward = _shouldNavigateForward.asStateFlow()

    fun onNextClick() {
        val nextStep = when (_onboardingStep.value) {
            OnboardingStep.DISCOVER_MARKETPLACE -> OnboardingStep.CREATE_GALLERY
            OnboardingStep.CREATE_GALLERY -> OnboardingStep.DISCOVER_WORLD_OF_ART
            OnboardingStep.DISCOVER_WORLD_OF_ART -> null
        }
        if (nextStep != null) {
            _onboardingStep.value = nextStep
        } else {
            _shouldNavigateForward.value = Unit
        }
    }
}
