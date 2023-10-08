package com.slothdeboss.enefte.ui.screens.setupProfile

import com.slothdeboss.enefte.domain.field.InputFieldState

data class SetupProfileState(
    val name: InputFieldState,
    val email: InputFieldState,
    val image: InputFieldState,
    val bio: InputFieldState
) {

    fun isAllDataValid(): Boolean {
        return listOf(name, email, image, bio).all { it.validation.isValid }
    }

    companion object {

        fun default(): SetupProfileState {
            return SetupProfileState(
                name = InputFieldState.default(),
                email = InputFieldState.default(),
                image = InputFieldState.image(),
                bio = InputFieldState.default()
            )
        }
    }
}
