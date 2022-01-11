package com.panvova.rickmorty.domain.usecase

import com.panvova.rickmorty.data.dto.episode.EpisodeResult
import com.panvova.rickmorty.domain.gateway.RickMortyGateway
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetEpisodesUseCase @Inject constructor(private val rickMortyGateway: RickMortyGateway) {
    fun getEpisodes(): Flow<EpisodeResult> {
        return rickMortyGateway.getEpisodes()
    }
}