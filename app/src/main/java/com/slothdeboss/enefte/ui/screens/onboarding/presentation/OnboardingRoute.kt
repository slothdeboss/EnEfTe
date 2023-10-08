package com.slothdeboss.enefte.ui.screens.onboarding.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import com.slothdeboss.enefte.ui.navigation.OnboardingDestinations
import org.koin.androidx.compose.koinViewModel

@Composable
fun OnboardingRoute(
    navController: NavHostController
) {

    val viewModel: OnboardingViewModel = koinViewModel()

    val step by viewModel.onboardingStep.collectAsState()
    val shouldNavigateForward by viewModel.shouldNavigateForward.collectAsState()

    LaunchedEffect(shouldNavigateForward) {
        if (shouldNavigateForward) {
            navController.navigate(OnboardingDestinations.START)
        }
    }

    OnboardingScreen(
        onboardingStep = step,
        onNextClick = viewModel::onNextClick
    )
}
