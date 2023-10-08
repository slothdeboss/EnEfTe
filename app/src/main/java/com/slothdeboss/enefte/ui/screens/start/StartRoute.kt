package com.slothdeboss.enefte.ui.screens.start

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.slothdeboss.enefte.ui.navigation.OnboardingDestinations

@Composable
fun StartRoute(
    navController: NavHostController
) {

    StartScreen(
        onConnectWithWalletClicked = {
            navController.navigate(OnboardingDestinations.CONNECT_WALLET)
        },
        onSkipClicked = {
            navController.navigate(OnboardingDestinations.WELCOME)
        }
    )
}
