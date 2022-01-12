package com.panvova.rickmorty.presentation.features.characterDetails.epoxy

import com.bumptech.glide.Glide
import com.panvova.rickmorty.R
import com.panvova.rickmorty.databinding.ModelCharacterDetailsImageBinding
import com.panvova.rickmorty.presentation.base.ViewBindingKotlinModel

data class CharacterDetailsImageEpoxyModel(
    val image: String,
) : ViewBindingKotlinModel<ModelCharacterDetailsImageBinding>(R.layout.model_character_details_image) {
    override fun ModelCharacterDetailsImageBinding.bind() {
        Glide.with(imageIV).load(image).into(imageIV)
    }
}