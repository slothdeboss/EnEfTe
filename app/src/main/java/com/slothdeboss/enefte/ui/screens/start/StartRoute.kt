package com.slothdeboss.enefte.ui.screens.start

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.slothdeboss.enefte.ui.navigation.OnboardingDestinations
import com.slothdeboss.enefte.ui.screens.base.RouteComposable
import org.koin.androidx.compose.koinViewModel

@Composable
fun StartRoute(
    navController: NavHostController
) {

    val viewModel: StartScreenViewModel = koinViewModel()

    RouteComposable(
        navController = navController,
        viewModel = viewModel
    ) {
        StartScreen(
            onEvent = viewModel::onEvent
        )
    }
}
