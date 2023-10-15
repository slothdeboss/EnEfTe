package com.slothdeboss.enefte.ui.components.navigation

import androidx.annotation.DrawableRes
import com.slothdeboss.enefte.R
import com.slothdeboss.enefte.ui.navigation.HomeDestinations

sealed class NavigationTab(
    val route: String,
    @DrawableRes
    val icon: Int
) {
    data object Home : NavigationTab(
        route = HomeDestinations.HOME,
        icon = R.drawable.ic_home
    )
    data object Discover : NavigationTab(
        route = HomeDestinations.DISCOVER,
        icon = R.drawable.ic_search
    )
    data object Ranks : NavigationTab(
        route = HomeDestinations.RANKS,
        icon = R.drawable.ic_rating
    )
    data object Profile : NavigationTab(
        route = HomeDestinations.PROFILE,
        icon = R.drawable.ic_profile
    )

    companion object {

        fun items() = listOf(Home, Discover, Ranks, Profile)
    }
}
