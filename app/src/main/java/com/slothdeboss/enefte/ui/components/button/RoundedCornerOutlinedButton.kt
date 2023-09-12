package com.slothdeboss.enefte.ui.components.button

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.slothdeboss.enefte.R
import com.slothdeboss.enefte.ui.theme.EnEfTeTheme

@Composable
fun RoundedCornerOutlinedButton(
    @DrawableRes icon: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val colors = EnEfTeTheme.colors

    OutlinedButton(
        modifier = modifier,
        shape = RoundedCornerShape(10.dp),
        onClick = onClick,
        border = BorderStroke(1.dp, color = colors.white)
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            tint = colors.white
        )
    }
}

@Preview
@Composable
private fun RoundedCornerOutlinedButtonPreview() {
    EnEfTeTheme {
        RoundedCornerOutlinedButton(
            icon = R.drawable.ic_forward,
            onClick = {  }
        )
    }
}