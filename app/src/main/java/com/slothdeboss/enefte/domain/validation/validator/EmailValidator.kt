package com.slothdeboss.enefte.domain.validation.validator

import android.content.Context
import android.util.Patterns
import com.slothdeboss.enefte.R
import com.slothdeboss.enefte.domain.validation.result.SingleValidationResult

class EmailValidator(private val context: Context) : StringValidator {
    override fun validate(value: String): SingleValidationResult {
        return when {
            value.isBlank() -> SingleValidationResult.error(context.getString(R.string.field_cant_be_blank))
            Patterns.EMAIL_ADDRESS.matcher(value).matches() -> SingleValidationResult.valid()
            else -> SingleValidationResult.error(context.getString(R.string.email_is_invalid))
        }
    }
}
