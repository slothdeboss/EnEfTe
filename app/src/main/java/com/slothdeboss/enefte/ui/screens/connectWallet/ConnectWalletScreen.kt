package com.slothdeboss.enefte.ui.screens.connectWallet

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.slothdeboss.enefte.R
import com.slothdeboss.enefte.ui.components.bottomSheet.WalletOptionBottomSheet
import com.slothdeboss.enefte.ui.components.clickableText.TermsAndPolicyClickableText
import com.slothdeboss.enefte.ui.components.topAppBar.TopBarWithLogo
import com.slothdeboss.enefte.ui.components.wallet.ConnectWalletOptions
import com.slothdeboss.enefte.ui.screens.connectWallet.entity.ConnectWalletState
import com.slothdeboss.enefte.ui.screens.connectWallet.entity.WalletOptionsProvider
import com.slothdeboss.enefte.ui.screens.connectWallet.event.ConnectWalletScreenEvent
import com.slothdeboss.enefte.ui.theme.EnEfTeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConnectWalletScreen(
    state: ConnectWalletState,
    onEvent: (event: ConnectWalletScreenEvent) -> Unit,
) {
    val colors = EnEfTeTheme.colors
    val typography = EnEfTeTheme.typography
    val dimensions = EnEfTeTheme.dimensions

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopBarWithLogo(
                onBackClicked = {
                    onEvent(ConnectWalletScreenEvent.OnBackClickedEvent)
                }
            )
        },
        containerColor = colors.dark
    ) { values ->
        Column(
            modifier = Modifier
                .padding(values)
                .fillMaxSize()
                .padding(
                    horizontal = dimensions.dimension24,
                    vertical = dimensions.dimension32
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(dimensions.dimension20))

            Image(
                painter = painterResource(id = R.drawable.ic_crypto_wallet),
                contentDescription = stringResource(id = R.string.crypto_wallet)
            )

            Spacer(modifier = Modifier.height(dimensions.dimension16))

            Text(
                text = stringResource(id = R.string.choose_your_wallet),
                style = typography.h1.copy(color = colors.white),
            )

            Spacer(modifier = Modifier.height(dimensions.dimension16))

            TermsAndPolicyClickableText(
                onTermsClick = { /*TODO*/ },
                onPolicyClick = { /*TODO*/ },
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(dimensions.dimension24))

            ConnectWalletOptions(
                options = WalletOptionsProvider.provideWalletOptions(),
                onOptionClick = { option ->
                    onEvent(
                        ConnectWalletScreenEvent.OnWalletOptionClicked(option = option)
                    )
                }
            )

            if (state.shouldShowBottomSheet()) {
                WalletOptionBottomSheet(
                    walletOption = state.option,
                    sheetsState = rememberModalBottomSheetState(),
                    onDismissRequest = {
                        onEvent(ConnectWalletScreenEvent.CloseBottomSheetEvent)
                    },
                    onContinueClick = {
                        onEvent(ConnectWalletScreenEvent.OnContinueClickedEvent)
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ConnectWalletScreenPreview() {
    EnEfTeTheme {
        ConnectWalletScreen(
            state = ConnectWalletState.default(),
            onEvent = {}
        )
    }
}
