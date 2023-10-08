package com.slothdeboss.enefte.ui.screens.start

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.slothdeboss.enefte.R
import com.slothdeboss.enefte.ui.components.button.RoundedCornerButton
import com.slothdeboss.enefte.ui.components.button.RoundedCornerOutlinedButton
import com.slothdeboss.enefte.ui.theme.EnEfTeTheme
import com.slothdeboss.enefte.ui.util.values.VerticalPadding24

@Composable
fun StartScreen(
    onConnectWithWalletClicked: () -> Unit,
    onSkipClicked: () -> Unit
) {

    val colors = EnEfTeTheme.colors
    val typography = EnEfTeTheme.typography

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = colors.dark
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 48.dp, horizontal = 24.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = stringResource(id = R.string.all_nfts_are_unique_and_ownable),
                style = typography.h1,
                color = colors.white
            )

            Spacer(modifier = VerticalPadding24)

            Text(
                text = stringResource(id = R.string.a_credible_and_excellent_marketplace),
                style = typography.body,
                color = colors.grayLight
            )

            Spacer(modifier = Modifier.weight(0.25f))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                RoundedCornerButton(
                    modifier = Modifier.weight(1f),
                    label = R.string.connect_with_wallet,
                    onClick = onConnectWithWalletClicked
                )

                RoundedCornerOutlinedButton(
                    modifier = Modifier.weight(0.3f),
                    icon = R.drawable.ic_forward,
                    onClick = onSkipClicked
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun StartScreenPreview() {
    EnEfTeTheme {
        StartScreen(
            onConnectWithWalletClicked = {},
            onSkipClicked = {}
        )
    }
}
