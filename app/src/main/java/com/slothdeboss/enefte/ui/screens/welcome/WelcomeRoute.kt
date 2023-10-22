package com.slothdeboss.enefte.ui.screens.welcome

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.slothdeboss.enefte.ui.navigation.HomeDestinations
import com.slothdeboss.enefte.ui.navigation.OnboardingDestinations
import com.slothdeboss.enefte.ui.screens.base.RouteComposable
import org.koin.androidx.compose.koinViewModel

@Composable
fun WelcomeRoute(
    navController: NavHostController
) {

    val viewModel: WelcomeViewModel = koinViewModel()

    RouteComposable(
        navController = navController,
        viewModel = viewModel
    ) {
        WelcomeScreen(
            closeScreen = viewModel::finishOnboardingFlow
        )
    }
}
