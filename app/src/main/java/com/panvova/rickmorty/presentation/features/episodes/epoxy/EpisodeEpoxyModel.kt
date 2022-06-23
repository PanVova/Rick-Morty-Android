package com.panvova.rickmorty.presentation.features.episodes.epoxy

import com.panvova.rickmorty.R
import com.panvova.rickmorty.databinding.ModelEpisodeBinding
import com.panvova.rickmorty.domain.model.Episode
import com.panvova.rickmorty.presentation.base.ViewBindingKotlinModel

data class EpisodeEpoxyModel(
    val episodeModel: Episode,
) : ViewBindingKotlinModel<ModelEpisodeBinding>(R.layout.model_episode) {
    override fun ModelEpisodeBinding.bind() {
        episode.text = episodeModel.episode
        name.text = episodeModel.name
    }
}