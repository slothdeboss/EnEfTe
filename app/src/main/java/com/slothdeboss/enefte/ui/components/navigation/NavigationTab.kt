package com.slothdeboss.enefte.ui.components.navigation

import androidx.annotation.DrawableRes
import com.slothdeboss.enefte.R
import com.slothdeboss.enefte.ui.navigation.HomeDestinations

enum class NavigationTab(
    val route: String,
    @DrawableRes
    val icon: Int
) {

    Home(
        route = HomeDestinations.HOME,
        icon = R.drawable.ic_home
    ),
    Discover(
        route = HomeDestinations.DISCOVER,
        icon = R.drawable.ic_search
    ),
    Ranks(
        route = HomeDestinations.RANKS,
        icon = R.drawable.ic_rating
    ),
    Profile(
        route = HomeDestinations.PROFILE,
        icon = R.drawable.ic_profile
    )
}
