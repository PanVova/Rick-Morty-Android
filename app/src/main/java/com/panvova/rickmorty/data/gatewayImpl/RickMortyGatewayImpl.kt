package com.panvova.rickmorty.data.gatewayImpl

import com.panvova.rickmorty.data.RickMortyAPI
import com.panvova.rickmorty.domain.gateway.RickMortyGateway
import com.panvova.rickmorty.domain.model.Character
import com.panvova.rickmorty.domain.model.Episode
import com.panvova.rickmorty.domain.model.Location
import com.panvova.rickmorty.domain.toDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RickMortyGatewayImpl(private val rickMortyAPI: RickMortyAPI) : RickMortyGateway {
    override fun getCharacters(): Flow<List<Character>> {
        return flow {
            emit(
                rickMortyAPI.getCharacters().results.map { characterResponse ->
                    characterResponse.toDomain()
                }
            )
        }
    }

    override fun getLocations(): Flow<List<Location>> {
        return flow {
            emit(
                rickMortyAPI.getLocations().results.map { locationResponse ->
                    locationResponse.toDomain()
                }
            )
        }
    }

    override fun getEpisodes(): Flow<List<Episode>> {
        return flow {
            emit(
                rickMortyAPI.getEpisodes().results.map { episodeResponse ->
                    episodeResponse.toDomain()
                }
            )
        }
    }
}