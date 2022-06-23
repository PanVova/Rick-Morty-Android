package com.panvova.rickmorty.presentation.features.characterDetails.epoxy

import com.panvova.rickmorty.R
import com.panvova.rickmorty.databinding.ModelCharacterDetailsInfoBinding
import com.panvova.rickmorty.domain.model.Character
import com.panvova.rickmorty.presentation.base.ViewBindingKotlinModel

data class CharacterDetailsInfoEpoxyModel(
    val character: Character,
) : ViewBindingKotlinModel<ModelCharacterDetailsInfoBinding>(R.layout.model_character_details_info) {
    override fun ModelCharacterDetailsInfoBinding.bind() {
        gender.text = character.gender
        name.text = character.name
        status.text = character.status
        species.text = character.species
    }
}