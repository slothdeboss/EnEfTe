package com.slothdeboss.enefte.di

import com.slothdeboss.enefte.domain.validation.validator.BioValidator
import com.slothdeboss.enefte.domain.validation.validator.EmailValidator
import com.slothdeboss.enefte.domain.validation.validator.NameValidator
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val ValidationModule = module {
    singleOf(::EmailValidator)
    singleOf(::NameValidator)
    singleOf(::BioValidator)
}
