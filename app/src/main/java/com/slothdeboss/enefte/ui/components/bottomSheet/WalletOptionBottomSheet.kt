package com.slothdeboss.enefte.ui.components.bottomSheet

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SheetState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.slothdeboss.enefte.R
import com.slothdeboss.enefte.ui.components.button.RoundedCornerButton
import com.slothdeboss.enefte.ui.screens.connectWallet.entity.WalletOption
import com.slothdeboss.enefte.ui.theme.EnEfTeTheme
import kotlinx.coroutines.launch

private const val IMAGE_SIZE = 128

// TODO - fix bug with bottom sheet when keyboard is open
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WalletOptionBottomSheet(
    walletOption: WalletOption,
    sheetsState: SheetState,
    onDismissRequest: () -> Unit,
    onContinueClick: (WalletOption) -> Unit,
) {

    val colors = EnEfTeTheme.colors
    val dimensions = EnEfTeTheme.dimensions
    val shapes = EnEfTeTheme.shapes

    var address by remember { mutableStateOf("") }

    val buttonPadding = if (walletOption.isManual()) {
        dimensions.dimension24
    } else {
        dimensions.dimension16
    }

    val scope = rememberCoroutineScope()

    ModalBottomSheet(
        onDismissRequest = onDismissRequest,
        containerColor = colors.dark,
        sheetState = sheetsState
    ) {
        Column(
            modifier = Modifier
                .clip(shapes.topDefault)
                .background(color = colors.dark)
                .padding(
                    start = dimensions.dimension24,
                    end = dimensions.dimension24,
                    bottom = dimensions.dimension44,
                    top = dimensions.dimension16
                )
        ) {

            if (walletOption.isManual()) {
                ManualEthereumWallet(
                    value = address,
                    onValueChanged = { address = it }
                )
            } else {
                ConnectToExternalWallet(
                    walletOption = walletOption
                )
            }

            Spacer(modifier = Modifier.height(buttonPadding))

            RoundedCornerButton(
                label = R.string.continue_label,
                onClick = {
                    scope.launch {
                        sheetsState.hide()
                        onContinueClick(walletOption)
                    }
                },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
private fun ManualEthereumWallet(
    value: String,
    onValueChanged: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val colors = EnEfTeTheme.colors
    val typography = EnEfTeTheme.typography
    val dimensions = EnEfTeTheme.dimensions
    val shapes = EnEfTeTheme.shapes

    Column(
        modifier = modifier
    ) {
        Text(
            text = stringResource(id = R.string.enter_ethereum_address),
            style = typography.h2.copy(color = colors.white)
        )

        Spacer(modifier = Modifier.height(dimensions.dimension16))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = value,
            onValueChange = onValueChanged,
            shape = shapes.default,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = colors.secondary,
                unfocusedContainerColor = colors.secondary,
                focusedTextColor = colors.white,
                unfocusedTextColor = colors.grayLight,
            ),
            label = {
                Text(
                    text = stringResource(id = R.string.address),
                    style = typography.body.copy(color = colors.grayLight)
                )
            }
        )
    }
}

@Composable
private fun ConnectToExternalWallet(
    walletOption: WalletOption,
    modifier: Modifier = Modifier
) {
    val colors = EnEfTeTheme.colors
    val typography = EnEfTeTheme.typography
    val dimensions = EnEfTeTheme.dimensions

    val messageTextRes = if (walletOption.isTrust()) {
        R.string.continue_with_trust_wallet
    } else {
        R.string.continue_with_metamask_wallet
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.size(IMAGE_SIZE.dp),
            painter = painterResource(id = walletOption.icon),
            contentDescription = stringResource(id = R.string.wallet_option)
        )

        Spacer(modifier = Modifier.height(dimensions.dimension16))

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = dimensions.dimension24),
            text = stringResource(id = messageTextRes),
            style = typography.body.copy(
                color = colors.grayLight,
                textAlign = TextAlign.Center
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun P() {
    EnEfTeTheme {
        Surface(color = EnEfTeTheme.colors.dark) {
            ManualEthereumWallet("", {})
        }
    }
}
