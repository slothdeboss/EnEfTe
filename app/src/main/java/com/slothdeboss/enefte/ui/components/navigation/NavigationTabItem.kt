package com.slothdeboss.enefte.ui.components.navigation

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.slothdeboss.enefte.ui.theme.EnEfTeTheme

@Composable
fun RowScope.NavigationTabItem(
    navigationTab: NavigationTab,
    isSelected: Boolean,
    onClick: () -> Unit,
) {
    val colors = EnEfTeTheme.colors

    NavigationBarItem(
        selected = isSelected,
        onClick = onClick,
        icon = { Icon(painter = painterResource(id = navigationTab.icon), contentDescription = null) },
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = colors.primary,
            unselectedIconColor = colors.grayLight,
            indicatorColor = colors.secondary
        )
    )
}
