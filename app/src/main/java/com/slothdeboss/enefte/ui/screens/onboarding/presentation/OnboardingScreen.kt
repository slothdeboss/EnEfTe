package com.slothdeboss.enefte.ui.screens.onboarding.presentation

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.flowWithLifecycle
import com.slothdeboss.enefte.R
import com.slothdeboss.enefte.ui.components.button.RoundedCornerButton
import com.slothdeboss.enefte.ui.components.tabs.CircleIndicatorRow
import com.slothdeboss.enefte.ui.screens.onboarding.entity.OnboardingPage
import com.slothdeboss.enefte.ui.screens.onboarding.entity.OnboardingState
import com.slothdeboss.enefte.ui.screens.onboarding.event.OnboardingEvent
import com.slothdeboss.enefte.ui.theme.EnEfTeTheme

private const val IMAGE_SIZE = 225

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingScreen(
    state: OnboardingState,
    onEvent: (event: OnboardingEvent) -> Unit
) {

    val pagerState = rememberPagerState { state.pages.size }
    val lifecycle = LocalLifecycleOwner.current.lifecycle

    BackHandler {
        onEvent(OnboardingEvent.OnPreviousOnboardingPageEvent)
    }

    LaunchedEffect(key1 = state) {
        if (state.currentPage != pagerState.currentPage) {
            pagerState.scrollToPage(state.currentPage)
        }
    }

    LaunchedEffect(key1 = Unit) {
        snapshotFlow { pagerState.currentPage }
            .flowWithLifecycle(lifecycle)
            .collect { page ->
                onEvent(OnboardingEvent.OnCurrentPageUpdatedEvent(page))
            }
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = EnEfTeTheme.colors.dark
    ) {
        HorizontalPager(
            state = pagerState,
            userScrollEnabled = false,
            modifier = Modifier.fillMaxSize(),
        ) { pageIndex ->
            val page = state.pages[pageIndex]
            OnboardingScreenPage(
                page = page,
                pagerState = pagerState,
                onEvent = onEvent,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun OnboardingScreenPage(
    page: OnboardingPage,
    pagerState: PagerState,
    onEvent: (event: OnboardingEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    val colors = EnEfTeTheme.colors
    val typography = EnEfTeTheme.typography
    val shapes = EnEfTeTheme.shapes
    val dimensions = EnEfTeTheme.dimensions

    Column(
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(1.5f),
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier.size(IMAGE_SIZE.dp),
                painter = painterResource(id = page.image),
                contentDescription = stringResource(id = R.string.onboarding_image)
            )
        }

        Column(
            Modifier
                .fillMaxSize()
                .weight(1.25f)
                .background(
                    color = colors.secondary,
                    shape = shapes.topLarge
                )
                .padding(
                    horizontal = dimensions.dimension24,
                    vertical = dimensions.dimension44
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = page.message),
                style = typography.h1.copy(
                    color = colors.white,
                    textAlign = TextAlign.Center
                ),
            )

            Spacer(modifier = Modifier.height(dimensions.dimension16))

            Text(
                text = stringResource(id = R.string.buy_and_sell_digital_items),
                style = typography.body.copy(
                    color = colors.white,
                    textAlign = TextAlign.Center
                ),
            )

            Spacer(modifier = Modifier.height(dimensions.dimension24))

            CircleIndicatorRow(
                pagesCount = pagerState.pageCount,
                currentPage = pagerState.currentPage
            )

            Spacer(modifier = Modifier.weight(1f))

            RoundedCornerButton(
                label = R.string.next,
                onClick = {
                    onEvent(OnboardingEvent.OnNextOnboardingPageEvent)
                },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun OnboardingScreenPreview() {
    EnEfTeTheme {
        OnboardingScreen(
            state = OnboardingState(),
            onEvent = {}
        )
    }
}
