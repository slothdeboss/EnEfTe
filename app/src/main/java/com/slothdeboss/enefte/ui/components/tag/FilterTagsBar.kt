package com.slothdeboss.enefte.ui.components.tag

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.slothdeboss.enefte.domain.tags.FilterTag
import com.slothdeboss.enefte.ui.theme.EnEfTeTheme

@Composable
fun FilterTagsBar(
    tags: List<FilterTag>,
    onTagClick: (tag: FilterTag) -> Unit,
    state: LazyListState,
    modifier: Modifier = Modifier,
    spaceBy: Dp = EnEfTeTheme.dimensions.dimension16,
    contentPadding: PaddingValues = PaddingValues()
) {
    LazyRow(
        modifier = modifier,
        state = state,
        horizontalArrangement = Arrangement.spacedBy(spaceBy),
        contentPadding = contentPadding
    ) {
        items(items = tags) { tag ->
            FilterTagBox(tag = tag, onTagClick = onTagClick)
        }
    }
}

@Preview
@Composable
private fun Preview() {
    EnEfTeTheme {
        FilterTagsBar(
            tags = emptyList(),
            onTagClick = {},
            state = rememberLazyListState()
        )
    }
}
