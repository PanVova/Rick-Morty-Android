package com.panvova.rickmorty

import android.app.Application
import com.panvova.rickmorty.di.AppComponent
import com.panvova.rickmorty.di.DaggerAppComponent
import timber.log.Timber

class App : Application() {
  override fun onCreate() {
    super.onCreate()

    Timber.plant(Timber.DebugTree())

    component = DaggerAppComponent
      .builder()
      .baseUrl(BuildConfig.API)
      .context(applicationContext)
      .build()
  }

  companion object {
    lateinit var component: AppComponent
  }
}