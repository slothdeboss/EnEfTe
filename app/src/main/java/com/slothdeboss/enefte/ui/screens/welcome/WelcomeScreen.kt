package com.slothdeboss.enefte.ui.screens.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.slothdeboss.enefte.R
import com.slothdeboss.enefte.ui.theme.EnEfTeTheme
import kotlinx.coroutines.delay

private const val DELAY = 3000L

@Composable
fun WelcomeScreen(closeScreen: () -> Unit) {

    val colors = EnEfTeTheme.colors
    val typography = EnEfTeTheme.typography
    val dimensions = EnEfTeTheme.dimensions

    LaunchedEffect(key1 = Unit) {
        delay(DELAY)
        closeScreen()
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = colors.dark
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.welcome_coin_palette),
                contentDescription = stringResource(id = R.string.welcome_image)
            )

            Spacer(modifier = Modifier.height(dimensions.dimension40))

            Text(
                text = stringResource(id = R.string.welcome),
                style = typography.h1.copy(color = colors.white)
            )

            Spacer(modifier = Modifier.height(dimensions.dimension16))

            Text(
                text = stringResource(id = R.string.create_and_sell_your_nft),
                style = typography.body.copy(color = colors.white)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WelcomeScreenPreview() {
    EnEfTeTheme {
        WelcomeScreen(closeScreen = {})
    }
}
