package com.slothdeboss.enefte.domain.validation.result

interface ValidationResult {
    val isValid: Boolean
    val error: String?
}
