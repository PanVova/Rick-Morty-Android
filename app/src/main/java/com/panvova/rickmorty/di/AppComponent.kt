package com.panvova.rickmorty.di

import android.content.Context
import com.panvova.rickmorty.presentation.features.characters.CharactersController
import com.panvova.rickmorty.presentation.features.episodes.EpisodeController
import com.panvova.rickmorty.presentation.features.locations.LocationController
import com.panvova.rickmorty.presentation.features.main.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Named

@Component(
    modules = [
        NetworkModule::class,
        GatewayModule::class,
        UtilsModule::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun baseUrl(@Named("url") url: String): Builder
        fun context(context: Context): Builder
        fun build(): AppComponent
    }

    fun inject(mainActivity: MainActivity)
    fun inject(episodeController: EpisodeController)
    fun inject(locationController: LocationController)
    fun inject(characterController: CharactersController)
}