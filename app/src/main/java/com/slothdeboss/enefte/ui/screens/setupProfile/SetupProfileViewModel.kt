package com.slothdeboss.enefte.ui.screens.setupProfile

import androidx.lifecycle.viewModelScope
import com.slothdeboss.enefte.domain.navigation.NavigationEffect
import com.slothdeboss.enefte.domain.validation.validator.BioValidator
import com.slothdeboss.enefte.domain.validation.validator.EmailValidator
import com.slothdeboss.enefte.domain.validation.validator.NameValidator
import com.slothdeboss.enefte.ui.navigation.OnboardingDestinations
import com.slothdeboss.enefte.ui.screens.base.BaseViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.flow.updateAndGet
import kotlinx.coroutines.launch

class SetupProfileViewModel(
    private val emailValidator: EmailValidator,
    private val nameValidator: NameValidator,
    private val bioValidator: BioValidator
) : BaseViewModel() {

    private val _state = MutableStateFlow(SetupProfileState.default())
    val state = _state.asStateFlow()

    private val _effect = Channel<SetupProfileEffect>()
    val effect = _effect.receiveAsFlow()

    fun onEvent(event: SetupProfileEvent) {
        when (event) {
            SetupProfileEvent.NavigateBack -> emitNavigationEffect(
                effect = NavigationEffect.NavigateBack
            )

            is SetupProfileEvent.UpdateField -> updateField(event)
            SetupProfileEvent.ValidateData -> validateUserData()
        }
    }

    private fun validateUserData() {
        val newState = _state.updateAndGet { currentState ->
            currentState.copy(
                name = with(currentState.name) {
                    copy(validation = nameValidator.validate(value))
                },
                email = with(currentState.email) {
                    copy(validation = emailValidator.validate(value))
                },
                bio = with(currentState.bio) {
                    copy(validation = bioValidator.validate(value))
                }
            )
        }
        if (newState.isAllDataValid()) {
            emitNavigationEffect(
                effect = NavigationEffect.NavigateForwardTo(
                    route = OnboardingDestinations.WELCOME
                )
            )
        }
    }

    private fun updateField(event: SetupProfileEvent.UpdateField) {
        val value = event.value
        when (event.type) {
            SetupProfileEvent.UpdateField.FieldType.NAME -> updateName(value)
            SetupProfileEvent.UpdateField.FieldType.EMAIL -> updateEmail(value)
            SetupProfileEvent.UpdateField.FieldType.BIO -> updateBio(value)
            SetupProfileEvent.UpdateField.FieldType.IMAGE -> updateImage(value)
        }
    }

    private fun updateEmail(value: String) {
        _state.update { currentState ->
            currentState.copy(
                email = currentState.email.copy(value = value)
            )
        }
    }

    private fun updateBio(value: String) {
        _state.update { currentState ->
            currentState.copy(
                bio = currentState.bio.copy(value = value)
            )
        }
    }

    private fun updateName(value: String) {
        _state.update { currentState ->
            currentState.copy(
                name = currentState.name.copy(value = value)
            )
        }
    }

    private fun updateImage(value: String) {
        _state.update { currentState ->
            currentState.copy(
                image = currentState.image.copy(value = value)
            )
        }
    }

    private fun sendEffect(effect: SetupProfileEffect) {
        viewModelScope.launch {
            _effect.send(effect)
        }
    }
}
