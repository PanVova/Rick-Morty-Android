package com.panvova.rickmorty.data.gatewayImpl

import com.panvova.rickmorty.data.RickMortyAPI
import com.panvova.rickmorty.data.dto.character.CharacterResult
import com.panvova.rickmorty.data.dto.episode.EpisodeResult
import com.panvova.rickmorty.data.dto.location.LocationResult
import com.panvova.rickmorty.domain.gateway.RickMortyGateway
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RickMortyGatewayImpl(private val rickMortyAPI: RickMortyAPI) : RickMortyGateway {
    override fun getCharacters(): Flow<CharacterResult> {
        return flow { rickMortyAPI.getCharacters() }
    }

    override fun getLocations(): Flow<LocationResult> {
        return flow { rickMortyAPI.getLocations() }
    }

    override fun getEpisodes(): Flow<EpisodeResult> {
        return flow { rickMortyAPI.getEpisodes() }
    }
}