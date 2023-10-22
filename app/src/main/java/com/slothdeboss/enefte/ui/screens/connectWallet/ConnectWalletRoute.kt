package com.slothdeboss.enefte.ui.screens.connectWallet

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import com.slothdeboss.enefte.ui.screens.base.RouteComposable
import org.koin.androidx.compose.koinViewModel

@Composable
fun ConnectWalletRoute(
    navController: NavHostController
) {

    val viewModel: ConnectWalletScreenViewModel = koinViewModel()
    val state by viewModel.state.collectAsState()

    RouteComposable(
        navController = navController,
        viewModel = viewModel
    ) {
        ConnectWalletScreen(
            state = state,
            onEvent = viewModel::onEvent
        )
    }
}
