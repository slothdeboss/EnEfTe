package com.slothdeboss.enefte.ui.screens.connectWallet

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.slothdeboss.enefte.ui.screens.connectWallet.entity.WalletOption
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ConnectWalletScreenViewModel : ViewModel() {

    private val _walletOptionEvent = MutableStateFlow(WalletOptionEvent.unspecified())
    val walletOptionEvent = _walletOptionEvent.asStateFlow()

    fun onOptionClick(option: WalletOption) {
        viewModelScope.launch {
            _walletOptionEvent.emit(WalletOptionEvent.create(option))
        }
    }

    fun bottomSheetClosed() {
        viewModelScope.launch {
            _walletOptionEvent.update { current ->
                current.copy(shouldShow = false)
            }
        }
    }
}
