package com.slothdeboss.enefte.domain.field

import com.slothdeboss.enefte.domain.validation.SingleValidationResult

data class InputFieldState(
    override val value: String,
    override val validation: SingleValidationResult
) : StringFieldState {

    companion object {

        fun default(): InputFieldState {
            return InputFieldState(
                value = "",
                validation = SingleValidationResult.valid()
            )
        }
    }
}
