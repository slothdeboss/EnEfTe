package com.slothdeboss.enefte.ui.screens.discover

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.slothdeboss.enefte.R
import com.slothdeboss.enefte.ui.components.category.CategoryItem
import com.slothdeboss.enefte.ui.components.collections.DiscoverCollectionItem
import com.slothdeboss.enefte.ui.components.listing.ListingItemSmall
import com.slothdeboss.enefte.ui.components.textField.SearchTextField
import com.slothdeboss.enefte.ui.components.titled.section.TitledSection
import com.slothdeboss.enefte.ui.theme.EnEfTeTheme

@Composable
fun DiscoverScreen() {

    val colors = EnEfTeTheme.colors
    val typography = EnEfTeTheme.typography
    val dimensions = EnEfTeTheme.dimensions

    Scaffold(
        containerColor = colors.dark
    ) { values ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(values)
                .padding(vertical = dimensions.dimension24)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = dimensions.dimension24)
            ) {
                Text(
                    text = stringResource(id = R.string.search),
                    style = typography.h1.copy(color = colors.white),
                    modifier = Modifier.padding()
                )

                Spacer(modifier = Modifier.height(dimensions.dimension24))

                SearchTextField(
                    value = "",
                    onValueChanged = {},
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Spacer(modifier = Modifier.height(dimensions.dimension40))

            Column(modifier = Modifier.fillMaxSize()) {
                TitledSection(
                    title = R.string.categories,
                    modifier = Modifier.fillMaxWidth(),
                    titlePadding = PaddingValues(start = dimensions.dimension24)
                ) {
                    LazyRow(
                        modifier = Modifier.fillMaxWidth(),
                        contentPadding = PaddingValues(horizontal = dimensions.dimension24),
                        horizontalArrangement = Arrangement.spacedBy(dimensions.dimension8)
                    ) {
                        items(10) {
                            CategoryItem()
                        }
                    }
                }

                Spacer(modifier = Modifier.height(dimensions.dimension16))

                TitledSection(
                    title = R.string.trending_collections,
                    modifier = Modifier.fillMaxWidth(),
                    titlePadding = PaddingValues(start = dimensions.dimension24)
                ) {
                    LazyHorizontalGrid(
                        modifier = Modifier.height((152.dp * 2) + 8.dp), // grids should have fixed size if nested
                        rows = GridCells.Fixed(count = 2),
                        contentPadding = PaddingValues(horizontal = dimensions.dimension24),
                        horizontalArrangement = Arrangement.spacedBy(dimensions.dimension16),
                        verticalArrangement = Arrangement.spacedBy(dimensions.dimension16)
                    ) {
                        items(10) {
                            DiscoverCollectionItem()
                        }
                    }
                }

                Spacer(modifier = Modifier.height(dimensions.dimension16))

                TitledSection(
                    title = R.string.items,
                    modifier = Modifier.fillMaxWidth(),
                    titlePadding = PaddingValues(start = dimensions.dimension24)
                ) {
                    LazyRow(
                        modifier = Modifier.fillMaxWidth(),
                        contentPadding = PaddingValues(horizontal = dimensions.dimension24),
                        horizontalArrangement = Arrangement.spacedBy(dimensions.dimension8)
                    ) {
                        items(10) {
                            ListingItemSmall()
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    EnEfTeTheme {
        DiscoverScreen()
    }
}
