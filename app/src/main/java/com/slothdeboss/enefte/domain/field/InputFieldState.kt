package com.slothdeboss.enefte.domain.field

import com.slothdeboss.enefte.domain.validation.result.SingleValidationResult

data class InputFieldState(
    override val value: String,
    override val validation: SingleValidationResult
) : StringFieldState {

    fun hasError() = validation.error != null

    companion object {
        private const val DEFAULT_ERROR = "Something went wrong"

        // Temporary solution
        fun image(): InputFieldState {
            return InputFieldState(
                value = "",
                validation = SingleValidationResult.valid()
            )
        }

        fun default(): InputFieldState {
            return InputFieldState(
                value = "",
                validation = SingleValidationResult.default()
            )
        }

        fun error(): InputFieldState {
            return InputFieldState(
                value = "",
                validation = SingleValidationResult.error(error = DEFAULT_ERROR)
            )
        }
    }
}
