package com.slothdeboss.enefte.ui.screens.connectWallet

import com.slothdeboss.enefte.domain.navigation.NavigationEffect
import com.slothdeboss.enefte.ui.navigation.OnboardingDestinations
import com.slothdeboss.enefte.ui.screens.base.BaseViewModel
import com.slothdeboss.enefte.ui.screens.connectWallet.entity.ConnectWalletState
import com.slothdeboss.enefte.ui.screens.connectWallet.entity.WalletOption
import com.slothdeboss.enefte.ui.screens.connectWallet.event.ConnectWalletScreenEvent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ConnectWalletScreenViewModel : BaseViewModel() {

    private val _state = MutableStateFlow(ConnectWalletState.default())
    val state = _state.asStateFlow()

    fun onEvent(event: ConnectWalletScreenEvent) {
        when (event) {
            ConnectWalletScreenEvent.CloseBottomSheetEvent -> updateBottomSheetState(shouldShow = false)
            is ConnectWalletScreenEvent.OnWalletOptionClicked -> updateWalletOption(event.option)
            ConnectWalletScreenEvent.OpenBottomSheetEvent -> updateBottomSheetState(shouldShow = true)
            ConnectWalletScreenEvent.OnBackClickedEvent -> emitNavigationEffect(
                NavigationEffect.NavigateBack
            )
            ConnectWalletScreenEvent.OnContinueClickedEvent -> {
                updateBottomSheetState(shouldShow = false)
                emitNavigationEffect(
                    NavigationEffect.NavigateForwardTo(route = OnboardingDestinations.SETUP_PROFILE)
                )
            }
        }
    }

    private fun updateWalletOption(option: WalletOption) {
        _state.update { currentState ->
            currentState.copy(
                option = option,
                shouldShow = true
            )
        }
    }

    private fun updateBottomSheetState(shouldShow: Boolean) {
        _state.update { currentState ->
            currentState.copy(
                shouldShow = shouldShow
            )
        }
    }
}
