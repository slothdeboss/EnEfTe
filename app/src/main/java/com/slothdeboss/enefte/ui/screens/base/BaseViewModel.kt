package com.slothdeboss.enefte.ui.screens.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.slothdeboss.enefte.domain.navigation.NavigationEffect
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

open class BaseViewModel : ViewModel() {

    private val _navigationEffect = Channel<NavigationEffect>()
    val navigationEffect = _navigationEffect.receiveAsFlow()

    protected fun emitNavigationEffect(effect: NavigationEffect) {
        viewModelScope.launch {
            _navigationEffect.send(effect)
        }
    }
}
