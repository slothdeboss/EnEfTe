package com.slothdeboss.enefte.ui.components.listing

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.slothdeboss.enefte.R
import com.slothdeboss.enefte.domain.listings.TrendingListing
import com.slothdeboss.enefte.ui.components.expireDate.ExpireDateLabel
import com.slothdeboss.enefte.ui.components.balance.PriceBox
import com.slothdeboss.enefte.ui.components.balance.PriceBoxDefaults
import com.slothdeboss.enefte.ui.components.image.VerifiedProfileImage
import com.slothdeboss.enefte.ui.theme.EnEfTeTheme

private const val REQUIRED_CARD_WIDTH = 268
private const val DEFAULT_DAYS_LEFT = 10

// TODO - split into smaller reusable components, add some UI logic to this card
@Composable
fun TrendingListingItem(
    listing: TrendingListing,
    onItemClick: (item: TrendingListing) -> Unit,
    modifier: Modifier = Modifier
) {

    val colors = EnEfTeTheme.colors
    val typography = EnEfTeTheme.typography
    val dimensions = EnEfTeTheme.dimensions

    Column(
        modifier = modifier
            .clickable { onItemClick(listing) }
            .width(REQUIRED_CARD_WIDTH.dp)
            .background(
                color = colors.secondary,
                shape = RoundedCornerShape(10.dp)
            )
            .padding(dimensions.dimension16)
    ) {
        Box(
            modifier = Modifier
                .requiredHeight(260.dp)
                .clip(RoundedCornerShape(10.dp))
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = listing.image),
                contentScale = ContentScale.FillHeight,
                contentDescription = null
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        vertical = dimensions.dimension10,
                        horizontal = dimensions.dimension8
                    )
                    .align(Alignment.TopCenter),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Surface(
                    shape = RoundedCornerShape(5.dp),
                    color = colors.secondary.copy(alpha = 0.5f)
                ) {
                    Text(
                        modifier = Modifier.padding(
                            horizontal = dimensions.dimension16,
                            vertical = dimensions.dimension4
                        ),
                        text = listing.category,
                        style = typography.caption.copy(color = colors.white)
                    )
                }

                Icon(
                    modifier = Modifier.clickable { },
                    painter = painterResource(id = R.drawable.ic_like_empty),
                    contentDescription = null
                )
            }
        }

        Spacer(modifier = Modifier.height(dimensions.dimension24))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = listing.collection.name,
                style = typography.body.copy(color = colors.white)
            )

            ExpireDateLabel(daysLeft = DEFAULT_DAYS_LEFT)
        }

        Spacer(modifier = Modifier.height(dimensions.dimension16))

        Row(
            modifier = Modifier
                .height(30.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(dimensions.dimension8)
            ) {
                VerifiedProfileImage(
                    image = painterResource(id = R.drawable.ic_pfp),
                    isVerified = true
                )

                Text(
                    text = listing.collection.name,
                    style = typography.smallCaption.copy(color = colors.white)
                )
            }

            PriceBox(
                value = 22.2,
                colors = PriceBoxDefaults.colors(
                    borderColor = colors.primary
                )
            )
        }

    }
}

@Preview
@Composable
private fun Preview() {
    EnEfTeTheme {
        TrendingListingItem(
            listing = TrendingListing.default(),
            onItemClick = {}
        )
    }
}
