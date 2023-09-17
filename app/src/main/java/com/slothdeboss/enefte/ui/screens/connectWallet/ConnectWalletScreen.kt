package com.slothdeboss.enefte.ui.screens.connectWallet

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.slothdeboss.enefte.R
import com.slothdeboss.enefte.ui.components.bottomSheet.WalletOptionBottomSheet
import com.slothdeboss.enefte.ui.components.clickableText.TermsAndPolicyClickableText
import com.slothdeboss.enefte.ui.components.wallet.ConnectWalletOptions
import com.slothdeboss.enefte.ui.screens.connectWallet.entity.WalletOptionsProvider
import com.slothdeboss.enefte.ui.theme.EnEfTeTheme
import com.slothdeboss.enefte.ui.util.values.VerticalPadding16
import com.slothdeboss.enefte.ui.util.values.VerticalPadding20
import com.slothdeboss.enefte.ui.util.values.VerticalPadding24

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConnectWalletScreen(
    onBackClicked: () -> Unit,
) {

    val viewModel: ConnectWalletScreenViewModel = viewModel()
    val walletOption = viewModel.walletOptionEvent.collectAsState()

    val colors = EnEfTeTheme.colors
    val typography = EnEfTeTheme.typography

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = colors.dark
    ) { values ->
        Column(
            modifier = Modifier
                .padding(values)
                .fillMaxSize()
                .padding(horizontal = 24.dp, vertical = 32.dp),
        ) {
            Box(modifier = Modifier.fillMaxWidth()) {
                Image(
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .size(28.dp)
                        .clickable { onBackClicked() },
                    painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = null
                )

                Image(
                    modifier = Modifier.align(Alignment.Center),
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = null
                )
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Spacer(modifier = VerticalPadding20)

                Image(
                    painter = painterResource(id = R.drawable.ic_crypto_wallet),
                    contentDescription = null
                )

                Spacer(modifier = VerticalPadding16)

                Text(
                    text = stringResource(id = R.string.choose_your_wallet),
                    style = typography.h1.copy(color = colors.white),
                )

                Spacer(modifier = VerticalPadding16)

                TermsAndPolicyClickableText(
                    onTermsClick = { /*TODO*/ },
                    onPolicyClick = { /*TODO*/ },
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = VerticalPadding24)

                ConnectWalletOptions(
                    options = WalletOptionsProvider.provideWalletOptions(),
                    onOptionClick = viewModel::onOptionClick
                )

                if (walletOption.value.shouldShowBottomSheet()) {
                    WalletOptionBottomSheet(
                        walletOption = walletOption.value.option,
                        sheetsState = rememberModalBottomSheetState(),
                        onDismissRequest = viewModel::bottomSheetClosed,
                        onContinueClick = {}
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ConnectWalletScreenPreview() {
    EnEfTeTheme {
        ConnectWalletScreen(
            onBackClicked = {}
        )
    }
}
