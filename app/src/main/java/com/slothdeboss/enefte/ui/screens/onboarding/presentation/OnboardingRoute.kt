package com.slothdeboss.enefte.ui.screens.onboarding.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import com.slothdeboss.enefte.ui.screens.base.RouteComposable
import org.koin.androidx.compose.koinViewModel

@Composable
fun OnboardingRoute(navController: NavHostController) {

    val viewModel: OnboardingViewModel = koinViewModel()
    val state by viewModel.state.collectAsState()

    RouteComposable(
        navController = navController,
        viewModel = viewModel
    ) {
        OnboardingScreen(
            state = state,
            onEvent = viewModel::onEvent
        )
    }
}
