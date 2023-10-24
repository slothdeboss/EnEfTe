package com.slothdeboss.enefte.ui.screens.welcome

import com.slothdeboss.enefte.domain.navigation.NavigationEffect
import com.slothdeboss.enefte.ui.navigation.HomeDestinations
import com.slothdeboss.enefte.ui.screens.base.BaseViewModel

class WelcomeViewModel : BaseViewModel() {

    fun finishOnboardingFlow() {
        emitNavigationEffect(
            NavigationEffect.NavigateForwardTo(
                route = HomeDestinations.HOME_CONTAINER,
                withPop = true
            )
        )
    }
}
