package com.panvova.rickmorty.presentation.features.locations.epoxy

import com.airbnb.epoxy.EpoxyController
import com.panvova.rickmorty.domain.model.Location

class LocationEpoxyController : EpoxyController() {

    var locations: List<Location> = listOf()
        set(value) {
            field = value
            requestModelBuild()
        }

    override fun buildModels() {
        locations.forEach { location ->
            buildLocation(location)
        }
    }

    private fun buildLocation(location: Location) {
        LocationEpoxyModel(location).id(location.id).addTo(this)
    }
}