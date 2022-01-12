package com.panvova.rickmorty.presentation.features.characters.epoxy

import com.bumptech.glide.Glide
import com.panvova.rickmorty.R
import com.panvova.rickmorty.databinding.ModelCharacterBinding
import com.panvova.rickmorty.domain.model.Character
import com.panvova.rickmorty.presentation.base.ViewBindingKotlinModel

data class CharacterEpoxyModel(
    val character: Character,
    val clickListener: (Character) -> Unit,
) : ViewBindingKotlinModel<ModelCharacterBinding>(R.layout.model_character) {
    override fun ModelCharacterBinding.bind() {
        name.text = character.name
        Glide
            .with(image)
            .load(character.image)
            .into(image)

        root.setOnClickListener {
            clickListener.invoke(character)
        }
    }
}