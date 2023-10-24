package com.slothdeboss.enefte.ui.screens.connectWallet.event

import com.slothdeboss.enefte.ui.screens.connectWallet.entity.WalletOption

sealed interface ConnectWalletScreenEvent {
    data class OnWalletOptionClicked(val option: WalletOption) : ConnectWalletScreenEvent
    data object OpenBottomSheetEvent : ConnectWalletScreenEvent
    data object CloseBottomSheetEvent : ConnectWalletScreenEvent
    data object OnBackClickedEvent : ConnectWalletScreenEvent
    data object OnContinueClickedEvent : ConnectWalletScreenEvent
}
