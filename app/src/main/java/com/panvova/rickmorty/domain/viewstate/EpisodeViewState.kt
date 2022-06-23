package com.panvova.rickmorty.domain.viewstate

import com.panvova.rickmorty.domain.model.Episode

sealed class EpisodeViewState {
    object Loading : EpisodeViewState()
    data class Success(val episodes: List<Episode>) : EpisodeViewState()
    data class Error(val error: String) : EpisodeViewState()
}