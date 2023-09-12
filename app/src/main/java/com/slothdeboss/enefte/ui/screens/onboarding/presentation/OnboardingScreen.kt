package com.slothdeboss.enefte.ui.screens.onboarding.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.slothdeboss.enefte.R
import com.slothdeboss.enefte.ui.components.button.RoundedCornerButton
import com.slothdeboss.enefte.ui.components.tabs.CircleIndicatorRow
import com.slothdeboss.enefte.ui.theme.EnEfTeTheme
import com.slothdeboss.enefte.ui.util.values.VerticalPadding16
import com.slothdeboss.enefte.ui.util.values.VerticalPadding24

private const val PAGES_COUNT = 3
private const val IMAGE_SIZE = 225

@Composable
fun OnboardingScreen(
    viewModel: OnboardingViewModel = viewModel()
) {

    val step by viewModel.onboardingStep.collectAsState()
    val shouldNavigateForward by viewModel.shouldNavigateForward.collectAsState()

    LaunchedEffect(shouldNavigateForward) {
        // TODO - navigate to the next screen
    }

    val colors = EnEfTeTheme.colors
    val typography = EnEfTeTheme.typography

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = colors.dark
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1.5f),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    modifier = Modifier.size(IMAGE_SIZE.dp),
                    painter = painterResource(id = step.getImage()),
                    contentDescription = null
                )
            }

            Column(
                Modifier
                    .fillMaxSize()
                    .weight(1.25f)
                    .background(
                        color = colors.secondary,
                        shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)
                    )
                    .padding(horizontal = 24.dp, vertical = 44.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = step.getStepTitle()),
                    style = typography.h1,
                    color = colors.white,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = VerticalPadding16)

                Text(
                    text = stringResource(id = R.string.buy_and_sell_digital_items),
                    style = typography.body,
                    color = colors.white,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = VerticalPadding24)

                CircleIndicatorRow(
                    pagesCount = PAGES_COUNT,
                    currentPage = step.ordinal
                )

                Spacer(modifier = Modifier.weight(1f))

                RoundedCornerButton(
                    label = R.string.next,
                    onClick = viewModel::onNextClick
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun OnboardingScreenPreview() {
    EnEfTeTheme {
        OnboardingScreen()
    }
}
