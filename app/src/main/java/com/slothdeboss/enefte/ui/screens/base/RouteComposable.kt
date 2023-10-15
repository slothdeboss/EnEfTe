package com.slothdeboss.enefte.ui.screens.base

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.flowWithLifecycle
import androidx.navigation.NavHostController
import com.slothdeboss.enefte.domain.navigation.NavigationEffect
import kotlinx.coroutines.flow.collectLatest

@Composable
fun RouteComposable(
    navController: NavHostController,
    viewModel: BaseViewModel,
    content: @Composable () -> Unit
) {
    val lifecycle = LocalLifecycleOwner.current.lifecycle

    LaunchedEffect(key1 = Unit) {
        viewModel.navigationEffect
            .flowWithLifecycle(lifecycle)
            .collectLatest { effect ->
                when (effect) {
                    NavigationEffect.NavigateBack -> {
                        navController.popBackStack()
                    }
                    is NavigationEffect.NavigateBackTo -> {
                        navController.popBackStack(
                            route = effect.route,
                            inclusive = effect.inclusive
                        )
                    }
                    is NavigationEffect.NavigateForwardTo -> {
                        navController.navigate(route = effect.route) {
                            if (effect.withPop) {
                                popUpTo(0)
                            }
                        }
                    }
                }
            }
    }

    content()
}
