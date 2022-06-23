package com.panvova.rickmorty.data.gatewayImpl

import com.panvova.rickmorty.data.RickMortyAPI
import com.panvova.rickmorty.db.dao.CharacterDao
import com.panvova.rickmorty.db.dao.EpisodeDao
import com.panvova.rickmorty.db.dao.LocationDao
import com.panvova.rickmorty.domain.gateway.RickMortyGateway
import com.panvova.rickmorty.domain.model.Character
import com.panvova.rickmorty.domain.model.Episode
import com.panvova.rickmorty.domain.model.Location
import com.panvova.rickmorty.domain.toDB
import com.panvova.rickmorty.domain.toDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RickMortyGatewayImpl(
        private val rickMortyAPI: RickMortyAPI,
        private val characterDao: CharacterDao,
        private val episodeDao: EpisodeDao,
        private val locationDao: LocationDao
) : RickMortyGateway {
    override fun getCharacters(): Flow<List<Character>> {
        return flow {
            if (characterDao.getAll().isEmpty()) {
                rickMortyAPI.getCharacters().results.map { characterResponse ->
                    characterDao.insert(characterResponse.toDB())
                }
            }
            val characters: List<Character> = characterDao.getAll().map { characterDB ->
                characterDB.toDomain()
            }

            emit(characters)
        }
    }

    override fun getLocations(): Flow<List<Location>> {
        return flow {
            if (locationDao.getAll().isEmpty()) {
                rickMortyAPI.getLocations().results.map { locationResponse ->
                    locationDao.insert(locationResponse.toDB())
                }
            }

            val locations: List<Location> = locationDao.getAll().map { locationDB ->
                locationDB.toDomain()
            }

            emit(locations)
        }
    }

    override fun getEpisodes(): Flow<List<Episode>> {
        return flow {
            if (episodeDao.getAll().isEmpty()) {
                rickMortyAPI.getEpisodes().results.map { episodeResponse ->
                    episodeDao.insert(episodeResponse.toDB())
                }
            }

            val episodes: List<Episode> = episodeDao.getAll().map { episodeDB ->
                episodeDB.toDomain()
            }

            emit(episodes)
        }
    }
}