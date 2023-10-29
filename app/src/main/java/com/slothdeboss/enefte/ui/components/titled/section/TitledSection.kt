package com.slothdeboss.enefte.ui.components.titled.section

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.slothdeboss.enefte.R
import com.slothdeboss.enefte.ui.theme.EnEfTeTheme

@Composable
fun TitledSection(
    @StringRes title: Int,
    modifier: Modifier = Modifier,
    titlePadding: PaddingValues = PaddingValues(),
    content: @Composable () -> Unit
) {
    TitledSection(
        title = stringResource(id = title),
        modifier = modifier,
        titlePadding = titlePadding,
        content = content
    )
}

@Composable
fun TitledSection(
    title: String,
    modifier: Modifier = Modifier,
    titlePadding: PaddingValues = PaddingValues(),
    content: @Composable () -> Unit
) {
    Column(modifier = modifier) {
        Text(
            text = title,
            style = EnEfTeTheme.typography.h2.copy(
                color = EnEfTeTheme.colors.white
            ),
            modifier = Modifier.padding(titlePadding)
        )

        Spacer(modifier = Modifier.height(EnEfTeTheme.dimensions.dimension16))

        content()
    }
}

@Preview
@Composable
private fun Preview() {
    EnEfTeTheme {
        TitledSection(
            title = R.string.trending_collections
        ) {

        }
    }
}
