package com.slothdeboss.enefte.ui.screens.setupProfile

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.flowWithLifecycle
import androidx.navigation.NavHostController
import com.slothdeboss.enefte.ui.navigation.OnboardingDestinations
import com.slothdeboss.enefte.ui.screens.base.RouteComposable
import org.koin.androidx.compose.koinViewModel

@Composable
fun SetupProfileRoute(navController: NavHostController) {

    val lifecycleOwner = LocalLifecycleOwner.current

    val viewModel: SetupProfileViewModel = koinViewModel()
    val setupProfileState by viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.effect
            .flowWithLifecycle(lifecycleOwner.lifecycle)
            .collect { effect ->
                when (effect) {
                    SetupProfileEffect.OpenImagePicker -> {
                        // TODO - implement later
                    }
                }
            }
    }

    RouteComposable(
        navController = navController,
        viewModel = viewModel
    ) {
        SetupProfileScreen(
            state = setupProfileState,
            onEvent = viewModel::onEvent
        )
    }
}
