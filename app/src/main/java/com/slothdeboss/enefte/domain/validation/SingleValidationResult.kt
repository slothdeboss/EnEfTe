package com.slothdeboss.enefte.domain.validation

data class SingleValidationResult(
    override val isValid: Boolean,
    override val error: String?
) : ValidationResult {

    companion object {

        fun valid() = SingleValidationResult(isValid = true, error = null)
        fun error(error: String) = SingleValidationResult(isValid = false, error = error)
    }
}
