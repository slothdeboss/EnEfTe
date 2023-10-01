package com.slothdeboss.enefte.ui.screens.connectWallet

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import com.slothdeboss.enefte.ui.components.bottomSheet.WalletOptionBottomSheet
import com.slothdeboss.enefte.ui.navigation.OnboardingDestinations
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConnectWalletRoute(
    navController: NavHostController
) {

    val viewModel: ConnectWalletScreenViewModel = koinViewModel()
    val walletOption by viewModel.walletOptionEvent.collectAsState()

    ConnectWalletScreen(
        onWalletOptionClick = viewModel::onOptionClick,
        onBackClicked = { navController.navigateUp() }
    )

    if (walletOption.shouldShowBottomSheet()) {
        WalletOptionBottomSheet(
            walletOption = walletOption.option,
            sheetsState = rememberModalBottomSheetState(),
            onDismissRequest = viewModel::bottomSheetClosed,
            onContinueClick = {
                navController.navigate(OnboardingDestinations.SETUP_PROFILE)
            }
        )
    }
}
