package com.slothdeboss.enefte.ui.screens.welcome

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.slothdeboss.enefte.ui.navigation.HomeDestinations
import com.slothdeboss.enefte.ui.navigation.OnboardingDestinations

@Composable
fun WelcomeRoute(
    navController: NavHostController
) {

    WelcomeScreen(
        closeScreen = {
            navController.navigate(HomeDestinations.HOME_CONTAINER) {
                popUpTo(0)
            }
        }
    )
}
