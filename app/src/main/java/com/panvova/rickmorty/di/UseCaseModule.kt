package com.panvova.rickmorty.di

import com.panvova.rickmorty.data.gatewayImpl.RickMortyGatewayImpl
import com.panvova.rickmorty.domain.gateway.RickMortyGateway
import com.panvova.rickmorty.domain.usecase.GetCharactersUseCase
import com.panvova.rickmorty.domain.usecase.GetEpisodesUseCase
import com.panvova.rickmorty.domain.usecase.GetLocationsUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single<RickMortyGateway> {
        RickMortyGatewayImpl(
            rickMortyAPI = get(),
            characterDao = get(),
            episodeDao = get(),
            locationDao = get()
        )
    }

    single { GetCharactersUseCase(get()) }
    single { GetEpisodesUseCase(get()) }
    single { GetLocationsUseCase(get()) }
}