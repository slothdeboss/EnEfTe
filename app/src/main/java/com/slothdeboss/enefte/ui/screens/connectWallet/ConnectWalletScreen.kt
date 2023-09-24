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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.slothdeboss.enefte.R
import com.slothdeboss.enefte.ui.components.clickableText.TermsAndPolicyClickableText
import com.slothdeboss.enefte.ui.components.wallet.ConnectWalletOptions
import com.slothdeboss.enefte.ui.screens.connectWallet.entity.WalletOption
import com.slothdeboss.enefte.ui.screens.connectWallet.entity.WalletOptionsProvider
import com.slothdeboss.enefte.ui.theme.EnEfTeTheme
import com.slothdeboss.enefte.ui.util.values.VerticalPadding16
import com.slothdeboss.enefte.ui.util.values.VerticalPadding20
import com.slothdeboss.enefte.ui.util.values.VerticalPadding24

@Composable
fun ConnectWalletScreen(
    onWalletOptionClick: (WalletOption) -> Unit,
    onBackClicked: () -> Unit,
) {

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
                    onOptionClick = onWalletOptionClick
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
            onWalletOptionClick = {},
            onBackClicked = {}
        )
    }
}
