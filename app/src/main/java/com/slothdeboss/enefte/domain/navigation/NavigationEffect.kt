package com.slothdeboss.enefte.domain.navigation

sealed interface NavigationEffect {
    data class NavigateForwardTo(
        val route: String,
        val withPop: Boolean = false
    ) : NavigationEffect
    data object NavigateBack : NavigationEffect
    data class NavigateBackTo(
        val route: String,
        val inclusive: Boolean = false
    ) : NavigationEffect
}
