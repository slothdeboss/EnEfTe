package com.slothdeboss.enefte.ui.screens.setupProfile

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

// TODO - implement MVI properly with state, event and effect. Add field validation
class SetupProfileViewModel : ViewModel() {

    private val _state = MutableStateFlow(SetupProfileState.default())
    val state = _state.asStateFlow()

    fun onEvent(event: SetupProfileEvent) {
        when(event) {
            SetupProfileEvent.NavigateBack -> {}
            is SetupProfileEvent.UpdateField -> {}
            SetupProfileEvent.ValidateData -> {}
        }
    }
}
