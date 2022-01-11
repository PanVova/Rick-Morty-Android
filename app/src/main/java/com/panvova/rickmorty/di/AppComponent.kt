package com.panvova.rickmorty.di

import dagger.BindsInstance
import dagger.Component
import javax.inject.Named

@Component(
    modules = [
        NetworkModule::class,
        GatewayModule::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun baseUrl(@Named("url") url: String): Builder

        fun build(): AppComponent
    }
}