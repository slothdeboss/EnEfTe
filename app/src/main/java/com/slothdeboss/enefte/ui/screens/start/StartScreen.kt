package com.slothdeboss.enefte.ui.screens.start

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.slothdeboss.enefte.R
import com.slothdeboss.enefte.ui.components.button.RoundedCornerButton
import com.slothdeboss.enefte.ui.components.button.RoundedCornerOutlinedButton
import com.slothdeboss.enefte.ui.screens.start.event.StartScreenEvent
import com.slothdeboss.enefte.ui.theme.EnEfTeTheme

@Composable
fun StartScreen(
    onEvent: (event: StartScreenEvent) -> Unit
) {

    val colors = EnEfTeTheme.colors
    val typography = EnEfTeTheme.typography
    val dimensions = EnEfTeTheme.dimensions

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = colors.dark
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    vertical = dimensions.dimension48,
                    horizontal = dimensions.dimension24
                )
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = stringResource(id = R.string.logo)
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = stringResource(id = R.string.all_nfts_are_unique_and_ownable),
                style = typography.h1.copy(color = colors.white),
            )

            Spacer(modifier = Modifier.height(dimensions.dimension24))

            Text(
                text = stringResource(id = R.string.a_credible_and_excellent_marketplace),
                style = typography.body.copy(color = colors.grayLight),
            )

            Spacer(modifier = Modifier.weight(0.25f))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(dimensions.dimension16)
            ) {
                RoundedCornerButton(
                    modifier = Modifier.weight(1f),
                    label = R.string.connect_with_wallet,
                    onClick = {
                        onEvent(StartScreenEvent.NavigateToConnectWalletEvent)
                    },
                )

                RoundedCornerOutlinedButton(
                    modifier = Modifier.weight(0.3f),
                    icon = R.drawable.ic_forward,
                    onClick = {
                        onEvent(StartScreenEvent.OnSkipEvent)
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun StartScreenPreview() {
    EnEfTeTheme {
        StartScreen { _ ->

        }
    }
}
