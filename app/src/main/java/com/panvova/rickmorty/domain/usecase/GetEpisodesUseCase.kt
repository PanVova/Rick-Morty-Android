package com.panvova.rickmorty.domain.usecase

import com.panvova.rickmorty.data.dto.episode.EpisodeResult
import com.panvova.rickmorty.domain.gateway.RickMortyGateway
import kotlinx.coroutines.flow.Flow

class GetEpisodesUseCase(private val rickMortyGateway: RickMortyGateway) {
    fun getEpisodes(): Flow<EpisodeResult> {
        return rickMortyGateway.getEpisodes()
    }
}