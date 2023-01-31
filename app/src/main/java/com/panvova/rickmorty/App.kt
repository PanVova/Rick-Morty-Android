package com.panvova.rickmorty

import android.app.Application
import com.panvova.rickmorty.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import timber.log.Timber

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())

        startKoin {
            androidContext(this@App)
            modules(modules)
        }
    }
}

val modules: List<Module>
    get() = listOf(
            featuresModule,
            networkModule,
            useCaseModule,
            databaseModule,
            dispatcherModule
    )