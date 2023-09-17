package com.slothdeboss.enefte.ui.screens.connectWallet.entity

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class WalletOption(
    val type: WalletType,
    @StringRes
    val name: Int,
    @DrawableRes
    val icon: Int,
    @StringRes
    val link: Int? = null
) {

    fun isMetamask() = type == WalletType.METAMASK
    fun isTrust() = type == WalletType.TRUST
    fun isManual() = type == WalletType.MANUAL
    fun isUnspecified() = type == WalletType.UNSPECIFIED

    enum class WalletType {
        METAMASK, TRUST, MANUAL, UNSPECIFIED
    }

    companion object {

        private const val UNSPECIFIED_RES_ID = -1

        fun unspecified(): WalletOption {
            return WalletOption(
                type = WalletType.UNSPECIFIED,
                name = UNSPECIFIED_RES_ID,
                icon = UNSPECIFIED_RES_ID,
            )
        }
    }
}
