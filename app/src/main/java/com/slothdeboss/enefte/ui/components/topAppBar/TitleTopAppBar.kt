package com.slothdeboss.enefte.ui.components.topAppBar

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.slothdeboss.enefte.R
import com.slothdeboss.enefte.ui.screens.setupProfile.SetupProfileEvent
import com.slothdeboss.enefte.ui.theme.EnEfTeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TitleTopAppBar(
    @StringRes title: Int,
    onBackPressed: () -> Unit
) {

    val colors = EnEfTeTheme.colors
    val typography = EnEfTeTheme.typography

    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(id = title),
                style = typography.h2.copy(color = colors.white)
            )
        },
        navigationIcon = {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clickable {
                        onBackPressed()
                    },
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = null
                )
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = colors.dark
        )
    )
}