package com.slothdeboss.enefte.domain.validation.validator

import com.slothdeboss.enefte.domain.validation.result.ValidationResult

interface Validator<T, R: ValidationResult> {
    fun validate(value: T): R
}

