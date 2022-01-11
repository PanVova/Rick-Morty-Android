package com.panvova.rickmorty.di

import com.panvova.rickmorty.data.RickMortyAPI
import com.panvova.rickmorty.data.gatewayImpl.RickMortyGatewayImpl
import com.panvova.rickmorty.domain.gateway.RickMortyGateway
import dagger.Module
import dagger.Provides

@Module
class GatewayModule {
    @Provides
    fun provideRickMortyGateway(rickMortyAPI: RickMortyAPI): RickMortyGateway {
        return RickMortyGatewayImpl(rickMortyAPI)
    }
}

