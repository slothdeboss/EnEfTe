package com.slothdeboss.enefte

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.slothdeboss.enefte.ui.screens.onboarding.presentation.OnboardingScreen
import com.slothdeboss.enefte.ui.screens.start.StartScreen
import com.slothdeboss.enefte.ui.theme.EnEfTeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EnEfTeTheme {
                StartScreen()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EnEfTeTheme {

    }
}