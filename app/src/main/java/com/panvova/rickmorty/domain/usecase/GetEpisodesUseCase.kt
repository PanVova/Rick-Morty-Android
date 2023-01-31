package com.panvova.rickmorty.domain.usecase

import com.panvova.rickmorty.domain.gateway.RickMortyGateway
import com.panvova.rickmorty.domain.model.Episode
import kotlinx.coroutines.flow.Flow

class GetEpisodesUseCase constructor(private val rickMortyGateway: RickMortyGateway) {
    fun getEpisodes(): Flow<List<Episode>> {
        return rickMortyGateway.getEpisodes()
    }
}