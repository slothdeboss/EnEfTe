package com.slothdeboss.enefte.ui.screens.connectWallet

import com.slothdeboss.enefte.ui.screens.connectWallet.entity.WalletOption

data class WalletOptionEvent(
    val shouldShow: Boolean,
    val option: WalletOption
) {

    fun shouldShowBottomSheet() = shouldShow && !option.isUnspecified()

    companion object {
        fun create(option: WalletOption) = WalletOptionEvent(
            option = option,
            shouldShow = true
        )

        fun unspecified() = WalletOptionEvent(
            option = WalletOption.unspecified(),
            shouldShow = false
        )
    }
}
