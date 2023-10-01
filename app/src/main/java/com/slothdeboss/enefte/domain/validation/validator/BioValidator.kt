package com.slothdeboss.enefte.domain.validation.validator

import android.content.Context
import com.slothdeboss.enefte.R
import com.slothdeboss.enefte.domain.validation.result.SingleValidationResult

class BioValidator(private val context: Context) : StringValidator {

    override fun validate(value: String): SingleValidationResult {
        return when {
            value.isBlank() -> SingleValidationResult.error(context.getString(R.string.field_cant_be_blank))
            else -> SingleValidationResult.valid()
        }
    }
}
