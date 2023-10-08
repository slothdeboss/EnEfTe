package com.slothdeboss.enefte.ui.components.imagePicker

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.slothdeboss.enefte.R
import com.slothdeboss.enefte.ui.theme.EnEfTeTheme

// TODO - update this component when implement image picker feature
@Composable
fun ImagePicker(
    onButtonClick: () -> Unit,
    @StringRes buttonLabel: Int,
    modifier: Modifier = Modifier
) {

    val colors = EnEfTeTheme.colors
    val typography = EnEfTeTheme.typography
    val dimensions = EnEfTeTheme.dimensions

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(dimensions.dimension16),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier.weight(1f),
            painter = painterResource(id = R.drawable.ic_pfp),
            contentDescription = null
        )

        OutlinedButton(
            modifier = Modifier.weight(1f),
            onClick = onButtonClick
        ) {
            Text(
                text = stringResource(id = buttonLabel),
                style = typography.button.copy(color = colors.white)
            )
        }
    }
}
