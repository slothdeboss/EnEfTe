package com.slothdeboss.enefte.ui.screens.start

import com.slothdeboss.enefte.domain.navigation.NavigationEffect
import com.slothdeboss.enefte.ui.navigation.OnboardingDestinations
import com.slothdeboss.enefte.ui.screens.base.BaseViewModel
import com.slothdeboss.enefte.ui.screens.start.event.StartScreenEvent

class StartScreenViewModel : BaseViewModel() {

    fun onEvent(event: StartScreenEvent) {
        when (event) {
            StartScreenEvent.NavigateToConnectWalletEvent -> {
                emitNavigationEffect(
                    NavigationEffect.NavigateForwardTo(
                        route = OnboardingDestinations.CONNECT_WALLET
                    )
                )
            }

            StartScreenEvent.OnSkipEvent -> {
                emitNavigationEffect(
                    NavigationEffect.NavigateForwardTo(
                        route = OnboardingDestinations.WELCOME
                    )
                )
            }
        }
    }
}
