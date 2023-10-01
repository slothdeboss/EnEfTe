package com.slothdeboss.enefte.ui.components.topAppBar

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.slothdeboss.enefte.R
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
            IconButton(onClick = onBackPressed) {
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