package com.panvova.rickmorty.presentation.features.episodes

import com.airbnb.epoxy.EpoxyController
import com.panvova.rickmorty.domain.model.Episode
import com.panvova.rickmorty.presentation.features.episodes.epoxyModels.EpisodeEpoxyModel

class EpisodeEpoxyController : EpoxyController() {

    var episodes: List<Episode> = listOf()
        set(value) {
            field = value
            requestModelBuild()
        }

    override fun buildModels() {
        episodes.forEach { episode ->
            buildEpisode(episode)
        }
    }

    private fun buildEpisode(episode: Episode) {
        EpisodeEpoxyModel(episode).id(episode.id).addTo(this)
    }
}