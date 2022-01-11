package com.panvova.rickmorty.domain.gateway

import com.panvova.rickmorty.domain.model.Character
import com.panvova.rickmorty.domain.model.Episode
import com.panvova.rickmorty.domain.model.Location
import kotlinx.coroutines.flow.Flow

interface RickMortyGateway {
    fun getCharacters(): Flow<List<Character>>
    fun getLocations(): Flow<List<Location>>
    fun getEpisodes(): Flow<List<Episode>>
}