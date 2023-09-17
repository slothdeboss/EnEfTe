package com.slothdeboss.enefte.ui.components.wallet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.slothdeboss.enefte.ui.screens.connectWallet.entity.WalletOption
import com.slothdeboss.enefte.ui.screens.connectWallet.entity.WalletOption.WalletType
import com.slothdeboss.enefte.ui.screens.connectWallet.entity.WalletOptionsProvider
import com.slothdeboss.enefte.ui.theme.EnEfTeTheme

@Composable
fun ConnectWalletOptions(
    options: List<WalletOption>,
    onOptionClick: (WalletOption) -> Unit,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        options.forEach { option ->
            WalletItem(option = option, onOptionClick = onOptionClick)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ConnectWalletOptionsPreview() {
    EnEfTeTheme {
        ConnectWalletOptions(
            options = WalletOptionsProvider.provideWalletOptions(),
            onOptionClick = {},
            modifier = Modifier.background(color = EnEfTeTheme.colors.dark)
        )
    }
}
