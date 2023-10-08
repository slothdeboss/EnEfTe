package com.slothdeboss.enefte.ui.screens.connectWallet.entity

import com.slothdeboss.enefte.R

object WalletOptionsProvider {

    fun provideWalletOptions(): List<WalletOption> {
        return listOf(
            WalletOption(
                type = WalletOption.WalletType.METAMASK,
                name = R.string.metamask,
                icon = R.drawable.ic_metamask,
                link = R.string.metamask_link
            ),
            WalletOption(
                type = WalletOption.WalletType.TRUST,
                name = R.string.trust_wallet,
                icon = R.drawable.ic_trust_wallet,
                link = R.string.trust_wallet_link
            ),
            WalletOption(
                type = WalletOption.WalletType.MANUAL,
                name = R.string.enter_ethereum_address,
                icon = R.drawable.ic_link
            )
        )
    }
}