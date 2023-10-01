package com.slothdeboss.enefte.domain.validation.validator

import android.content.Context
import com.slothdeboss.enefte.R
import com.slothdeboss.enefte.domain.validation.result.SingleValidationResult

class NameValidator(private val context: Context) : StringValidator {
    override fun validate(value: String): SingleValidationResult {
        return when {
            value.isBlank() -> SingleValidationResult.error(context.getString(R.string.field_cant_be_blank))
            value.length < MIN_LENGTH -> SingleValidationResult.error(context.getString(R.string.username_is_to_short))
            else -> SingleValidationResult.valid()

        }
    }

    companion object {
        private const val MIN_LENGTH = 10
    }
}
