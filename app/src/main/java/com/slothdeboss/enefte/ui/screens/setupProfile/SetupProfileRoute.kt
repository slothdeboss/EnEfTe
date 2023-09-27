package com.slothdeboss.enefte.ui.screens.setupProfile

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController

@Composable
fun SetupProfileRoute(
    navController: NavHostController
) {

    val viewModel: SetupProfileViewModel = viewModel()

    val setupProfileState by viewModel.state.collectAsState()

    SetupProfileScreen(
        state = setupProfileState,
        onEvent = viewModel::onEvent
    )
}
