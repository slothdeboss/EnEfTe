package com.slothdeboss.enefte

import android.app.Application
import com.slothdeboss.enefte.di.EnEfTeModules
import com.slothdeboss.enefte.di.ResourceProvidersModule
import com.slothdeboss.enefte.di.ValidationModule
import com.slothdeboss.enefte.di.ViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class EnEfTeApp: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@EnEfTeApp)
            androidLogger(level = Level.ERROR)
            modules(EnEfTeModules)
        }
    }
}
