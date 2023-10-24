package com.slothdeboss.enefte.ui.components.button

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.slothdeboss.enefte.R
import com.slothdeboss.enefte.ui.theme.EnEfTeTheme

@Composable
fun RoundedCornerButton(
    @StringRes label: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    colors: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = EnEfTeTheme.colors.primary,
        contentColor = EnEfTeTheme.colors.white,
        disabledContainerColor = EnEfTeTheme.colors.grayLight,
        disabledContentColor = EnEfTeTheme.colors.secondary
    )
) {
    RoundedCornerButton(
        label = stringResource(id = label),
        modifier = modifier,
        colors = colors,
        onClick = onClick
    )
}

@Composable
fun RoundedCornerButton(
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    colors: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = EnEfTeTheme.colors.primary,
        contentColor = EnEfTeTheme.colors.white,
        disabledContainerColor = EnEfTeTheme.colors.grayLight,
        disabledContentColor = EnEfTeTheme.colors.secondary
    )
) {
    val typography = EnEfTeTheme.typography
    val shapes = EnEfTeTheme.shapes

    Button(
        modifier = modifier,
        colors = colors,
        shape = shapes.default,
        onClick = onClick
    ) {
        Text(
            text = label,
            style = typography.button
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun RoundedCornerButtonPreview() {
    EnEfTeTheme {
        RoundedCornerButton(
            label = R.string.next,
            onClick = {}
        )
    }
}
