package com.panvova.rickmorty.presentation.features.episodes

import com.panvova.rickmorty.domain.model.Episode
import com.panvova.rickmorty.presentation.base.BaseView

interface EpisodeView: BaseView {
    fun showEpisodes(episodes: List<Episode>)
}