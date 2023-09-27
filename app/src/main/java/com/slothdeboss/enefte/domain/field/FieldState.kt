package com.slothdeboss.enefte.domain.field

import com.slothdeboss.enefte.domain.validation.ValidationResult

interface FieldState<T> {
    val value: T
    val validation: ValidationResult
}

interface StringFieldState : FieldState<String>
