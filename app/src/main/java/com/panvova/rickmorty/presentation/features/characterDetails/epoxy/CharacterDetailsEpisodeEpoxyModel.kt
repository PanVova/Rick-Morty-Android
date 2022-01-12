package com.panvova.rickmorty.presentation.features.characterDetails.epoxy

import com.panvova.rickmorty.R
import com.panvova.rickmorty.databinding.ModelCharacterDetailsEpisodeBinding
import com.panvova.rickmorty.presentation.base.ViewBindingKotlinModel

data class CharacterDetailsEpisodeEpoxyModel(
    val episode: String,
) : ViewBindingKotlinModel<ModelCharacterDetailsEpisodeBinding>(R.layout.model_character_details_episode) {
    override fun ModelCharacterDetailsEpisodeBinding.bind() {
        episodeTV.text = episode
    }
}