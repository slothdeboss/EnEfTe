package com.slothdeboss.enefte.ui.components.topAppBar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.slothdeboss.enefte.R
import com.slothdeboss.enefte.ui.components.balance.AccountBalance
import com.slothdeboss.enefte.ui.theme.EnEfTeTheme

// TODO - add user balance and image parameters to this composable
@Composable
fun HomeTopAppBar(
    onProfilePictureClick: () -> Unit,
    modifier: Modifier = Modifier,
    onBalanceClick: () -> Unit = {},
    paddingValues: PaddingValues = PaddingValues(
        horizontal = EnEfTeTheme.dimensions.dimension24,
        vertical = EnEfTeTheme.dimensions.dimension8
    )
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .requiredHeight(56.dp)
            .background(color = EnEfTeTheme.colors.dark)
            .padding(paddingValues),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        AccountBalance(
            userBalance = 226.2,
            onClick = onBalanceClick
        )

        Image(
            modifier = Modifier
                .size(52.dp)
                .clickable { onProfilePictureClick() },
            painter = painterResource(id = R.drawable.ic_pfp),
            contentDescription = null
        )
    }
}

@Preview
@Composable
private fun Preview() {
    EnEfTeTheme {
        HomeTopAppBar(onProfilePictureClick = {})
    }
}
