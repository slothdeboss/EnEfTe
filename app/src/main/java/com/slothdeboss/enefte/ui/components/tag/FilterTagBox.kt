package com.slothdeboss.enefte.ui.components.tag

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.slothdeboss.enefte.domain.tags.FilterTag
import com.slothdeboss.enefte.ui.theme.EnEfTeTheme

@Composable
fun FilterTagBox(
    tag: FilterTag,
    onTagClick: (tag: FilterTag) -> Unit,
    modifier: Modifier = Modifier
) {
    val colors = EnEfTeTheme.colors
    val typography = EnEfTeTheme.typography

    val backgroundColor = if (tag.isSelected) colors.primary else colors.secondary

    Box(
        modifier = modifier
            .background(shape = RoundedCornerShape(10.dp), color = backgroundColor)
            .clickable { onTagClick(tag) }
            .padding(vertical = 12.dp, horizontal = 24.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = tag.title,
            style = typography.button.copy(color = colors.white)
        )
    }
}


@Preview
@Composable
private fun Preview() {
    EnEfTeTheme {
        Column {
            FilterTagBox(
                tag = FilterTag(
                    title = "Selected",
                    isSelected = true
                ),
                onTagClick = {}
            )
            Spacer(modifier = Modifier.height(8.dp))
            FilterTagBox(
                tag = FilterTag(
                    title = "Unselected",
                    isSelected = false
                ),
                onTagClick = {}
            )
        }
    }
}
