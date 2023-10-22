package com.slothdeboss.enefte.ui.components.bottomNavigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.slothdeboss.enefte.ui.components.navigation.NavigationTab
import com.slothdeboss.enefte.ui.components.navigation.NavigationTabItem
import com.slothdeboss.enefte.ui.theme.EnEfTeTheme

@Composable
fun BottomNavigation(
    navController: NavHostController,
    tabs: Array<NavigationTab>
) {
    val colors = EnEfTeTheme.colors

    androidx.compose.material.BottomNavigation(
        backgroundColor = colors.secondary,
    ) {
        val entry by navController.currentBackStackEntryAsState()
        val currentDestination = entry?.destination
        tabs.forEach { tab ->
            NavigationTabItem(
                navigationTab = tab,
                isSelected = currentDestination?.hierarchy?.any { it.route == tab.route } == true,
                onClick = {
                    navController.navigate(tab.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
            )
        }
    }
}
