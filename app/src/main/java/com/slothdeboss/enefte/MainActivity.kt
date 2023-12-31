package com.slothdeboss.enefte

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.slothdeboss.enefte.ui.navigation.EnEfTeNavigation
import com.slothdeboss.enefte.ui.theme.EnEfTeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EnEfTeTheme {
                EnEfTeNavigation()
            }
        }
    }
}
