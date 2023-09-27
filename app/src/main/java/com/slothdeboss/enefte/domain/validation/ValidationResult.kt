package com.slothdeboss.enefte.domain.validation

interface ValidationResult {
    val isValid: Boolean
    val error: String?
}
