package com.nishan.auth.data.di

import com.nishan.auth.data.EmailPatternValidator
import com.nishan.auth.domain.PatternValidator
import com.nishan.auth.domain.UserDataValidator
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val authDataModule = module {
    single<PatternValidator> { EmailPatternValidator }

    singleOf(::UserDataValidator)
}