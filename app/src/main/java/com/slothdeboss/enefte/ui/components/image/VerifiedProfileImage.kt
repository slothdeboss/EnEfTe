package com.slothdeboss.enefte.ui.components.image

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.slothdeboss.enefte.R
import com.slothdeboss.enefte.ui.theme.EnEfTeTheme

@Composable
fun VerifiedProfileImage(
    image: Painter,
    isVerified: Boolean,
    modifier: Modifier = Modifier,
    size: Dp = 32.dp,
    onClick: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .size(size)
            .clickable(onClick = onClick)
    ) {
        Image(
            painter = image,
            contentDescription = "Profile image",
            modifier = Modifier
                .fillMaxSize()
                .clip(CircleShape)
        )

        if (isVerified) {
            Image(
                painter = painterResource(
                    id = R.drawable.ic_verified
                ),
                contentDescription = "Verified icon",
                modifier = Modifier.align(Alignment.BottomEnd)
            )
        }
    }
}

@Preview
@Composable
private fun Preview() {
    EnEfTeTheme {
        VerifiedProfileImage(
            image = painterResource(id = R.drawable.dummy_image),
            isVerified = true
        )
    }
}
