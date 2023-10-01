package com.slothdeboss.enefte.ui.screens.setupProfile

sealed interface SetupProfileEffect {
    data object NavigateBack : SetupProfileEffect
    data object NavigateForward : SetupProfileEffect
    data object OpenImagePicker : SetupProfileEffect
}
