package com.slothdeboss.enefte.ui.components.topAppBar

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.slothdeboss.enefte.R
import com.slothdeboss.enefte.ui.theme.EnEfTeTheme

@Composable
fun TopBarWithLogo(
    onBackClicked: () -> Unit,
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues = PaddingValues(
        horizontal = EnEfTeTheme.dimensions.dimension24,
        vertical = EnEfTeTheme.dimensions.dimension16
    )
) {
    Box(modifier = modifier
        .fillMaxWidth()
        .padding(paddingValues)
    ) {
        Image(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .size(28.dp)
                .clickable(onClick = onBackClicked),
            painter = painterResource(id = R.drawable.ic_back),
            contentDescription = stringResource(id = R.string.back)
        )

        Image(
            modifier = Modifier.align(Alignment.Center),
            painter = painterResource(id = R.drawable.logo),
            contentDescription = stringResource(id = R.string.logo)
        )
    }
}

@Preview
@Composable
private fun Preview() {
    EnEfTeTheme {
        TopBarWithLogo(
            onBackClicked = {}
        )
    }
}
