package com.panvova.rickmorty.domain.gateway

import com.panvova.rickmorty.data.dto.character.CharacterResult
import com.panvova.rickmorty.data.dto.episode.EpisodeResult
import com.panvova.rickmorty.data.dto.location.LocationResult
import kotlinx.coroutines.flow.Flow

interface RickMortyGateway {
    fun getCharacters(): Flow<CharacterResult>
    fun getLocations(): Flow<LocationResult>
    fun getEpisodes(): Flow<EpisodeResult>
}