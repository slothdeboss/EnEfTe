package com.slothdeboss.enefte.ui.components.button

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
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
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    RoundedCornerButton(
        label = stringResource(id = label),
        modifier = modifier,
        onClick = onClick
    )
}

@Composable
fun RoundedCornerButton(
    label: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    val colors = EnEfTeTheme.colors
    val typography = EnEfTeTheme.typography

    Button(
        modifier = modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = colors.primary,
            contentColor = colors.white,
            disabledContainerColor = colors.grayLight,
            disabledContentColor = colors.secondary
        ),
        shape = RoundedCornerShape(10.dp),
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
        RoundedCornerButton(label = R.string.next)
    }
}
