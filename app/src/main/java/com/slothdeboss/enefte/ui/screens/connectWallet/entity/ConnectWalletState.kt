package com.slothdeboss.enefte.ui.screens.connectWallet.entity

data class ConnectWalletState(
    val shouldShow: Boolean,
    val option: WalletOption
) {

    fun shouldShowBottomSheet() = shouldShow && !option.isUnspecified()

    companion object {

        fun default() = ConnectWalletState(
            option = WalletOption.unspecified(),
            shouldShow = false
        )
    }
}
