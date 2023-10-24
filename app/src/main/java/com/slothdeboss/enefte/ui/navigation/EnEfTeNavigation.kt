package com.slothdeboss.enefte.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.slothdeboss.enefte.ui.screens.connectWallet.ConnectWalletRoute
import com.slothdeboss.enefte.ui.screens.home.HomeContainerRoute
import com.slothdeboss.enefte.ui.screens.onboarding.presentation.OnboardingRoute
import com.slothdeboss.enefte.ui.screens.setupProfile.SetupProfileRoute
import com.slothdeboss.enefte.ui.screens.start.StartRoute
import com.slothdeboss.enefte.ui.screens.welcome.WelcomeRoute

@Composable
fun EnEfTeNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = OnboardingDestinations.ONBOARDING
    ) {
        composable(route = OnboardingDestinations.ONBOARDING) {
            OnboardingRoute(navController = navController)
        }

        composable(route = OnboardingDestinations.START) {
            StartRoute(navController = navController)
        }

        composable(route = OnboardingDestinations.CONNECT_WALLET) {
            ConnectWalletRoute(navController = navController)
        }

        composable(route = OnboardingDestinations.WELCOME) {
            WelcomeRoute(navController = navController)
        }

        composable(route = OnboardingDestinations.SETUP_PROFILE) {
            SetupProfileRoute(navController = navController)
        }

        composable(route = HomeDestinations.HOME_CONTAINER) {
            HomeContainerRoute(parentNavController = navController)
        }
    }
}
