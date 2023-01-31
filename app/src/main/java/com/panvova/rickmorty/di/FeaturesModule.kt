package com.panvova.rickmorty.di

import com.panvova.rickmorty.presentation.features.characters.CharactersPresenter
import com.panvova.rickmorty.presentation.features.episodes.EpisodePresenter
import com.panvova.rickmorty.presentation.features.locations.LocationPresenter
import org.koin.dsl.module

val featuresModule = module {
    factory { CharactersPresenter(get()) }
    factory { EpisodePresenter(get()) }
    factory { LocationPresenter(get()) }
}