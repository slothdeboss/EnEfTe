package com.slothdeboss.enefte.ui.util.backPressedHandler

import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect

@Composable
fun BackPressedHandler(onBackPressed: () -> Unit) {
    val backDispatcher = LocalOnBackPressedDispatcherOwner.current

    DisposableEffect(key1 = Unit) {
        val callback = object : OnBackPressedCallback(enabled = true) {
            override fun handleOnBackPressed() {
                onBackPressed()
            }
        }

        backDispatcher?.onBackPressedDispatcher?.addCallback(callback)

        onDispose {
            callback.remove()
        }
    }
}
