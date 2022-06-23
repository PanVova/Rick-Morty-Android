package com.panvova.rickmorty.presentation.features.locations.epoxy

import com.panvova.rickmorty.R
import com.panvova.rickmorty.databinding.ModelLocationBinding
import com.panvova.rickmorty.domain.model.Location
import com.panvova.rickmorty.presentation.base.ViewBindingKotlinModel

data class LocationEpoxyModel(
    val locationModel: Location,
) : ViewBindingKotlinModel<ModelLocationBinding>(R.layout.model_location) {
    override fun ModelLocationBinding.bind() {
        name.text = locationModel.name
        type.text = locationModel.type
        dimension.text = locationModel.dimension
    }
}