package com.nishan.pacepal

import android.app.Application
import android.os.Build
import com.nishan.auth.data.di.authDataModule
import com.nishan.auth.presentation.di.authViewModelModule
import com.nishan.pacepal.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.dsl.module
import timber.log.Timber

class PacePalApp: Application() {
    override fun onCreate() {
        super.onCreate()
        if(BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }

        startKoin{
            androidLogger()
            androidContext(this@PacePalApp)
            modules(
                authViewModelModule,
                authDataModule,
                appModule
            )
        }
    }
}