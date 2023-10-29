package com.slothdeboss.enefte.ui.components.category

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.slothdeboss.enefte.R
import com.slothdeboss.enefte.ui.theme.EnEfTeTheme

@Composable
fun CategoryItem(
    modifier: Modifier = Modifier,
    size: CategoryItemSize = CategoryItemDefaults.size()
) {
    Box(
        modifier = modifier
            .clip(EnEfTeTheme.shapes.default)
            .height(size.height)
            .width(size.width)
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.dummy_image),
            contentDescription = "Category image",
            contentScale = ContentScale.Crop
        )

        Text(
            text = "My category",
            style = EnEfTeTheme.typography.button.copy(
                color = EnEfTeTheme.colors.white
            ),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = EnEfTeTheme.dimensions.dimension8)
        )
    }
}

object CategoryItemDefaults {

    fun size(
        height: Dp = 96.dp,
        width: Dp = 130.dp
    ): CategoryItemSize {
        return CategoryItemSize(
            height = height,
            width = width
        )
    }
}

data class CategoryItemSize(
    val height: Dp,
    val width: Dp
)

@Preview
@Composable
private fun Preview() {
    EnEfTeTheme {
        CategoryItem()
    }
}
