package com.slothdeboss.enefte.ui.screens.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.slothdeboss.enefte.ui.components.bottomNavigation.BottomNavigation
import com.slothdeboss.enefte.ui.components.navigation.NavigationTab
import com.slothdeboss.enefte.ui.navigation.HomeDestinations
import com.slothdeboss.enefte.ui.screens.discover.DiscoverRoute
import com.slothdeboss.enefte.ui.screens.profile.ProfileRoute
import com.slothdeboss.enefte.ui.screens.ranks.RanksRoute
import com.slothdeboss.enefte.ui.theme.EnEfTeTheme

@Composable
fun HomeContainerRoute(
    parentNavController: NavHostController
) {

    val navController = rememberNavController()

    val colors = EnEfTeTheme.colors

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = colors.dark,
        bottomBar = {
            BottomNavigation(
                navController = navController,
                tabs = NavigationTab.items()
            )
        }
    ) { paddingValues ->
        NavHost(
            modifier = Modifier.padding(paddingValues),
            navController = navController,
            startDestination = HomeDestinations.HOME
        ) {
            composable(route = HomeDestinations.HOME) {
                HomeRoute(navController = parentNavController)
            }
            composable(route = HomeDestinations.DISCOVER) {
                DiscoverRoute()
            }
            composable(route = HomeDestinations.RANKS) {
                RanksRoute()
            }
            composable(route = HomeDestinations.PROFILE) {
                ProfileRoute()
            }
        }
    }
}
