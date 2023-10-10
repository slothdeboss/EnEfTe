package com.slothdeboss.enefte.ui.screens.setupProfile

sealed interface SetupProfileEffect {
    data object OpenImagePicker : SetupProfileEffect
}
