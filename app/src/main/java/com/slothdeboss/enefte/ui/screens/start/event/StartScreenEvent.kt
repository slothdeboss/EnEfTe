package com.slothdeboss.enefte.ui.screens.start.event

sealed interface StartScreenEvent {
    data object NavigateToConnectWalletEvent : StartScreenEvent
    data object OnSkipEvent : StartScreenEvent
}
