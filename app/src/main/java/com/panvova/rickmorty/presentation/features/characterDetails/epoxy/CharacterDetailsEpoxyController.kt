package com.panvova.rickmorty.presentation.features.characterDetails.epoxy

import com.airbnb.epoxy.CarouselModel_
import com.airbnb.epoxy.EpoxyController
import com.panvova.rickmorty.domain.model.Character

class CharacterDetailsEpoxyController : EpoxyController() {

    var character: Character = Character()
        set(value) {
            field = value
            requestModelBuild()
        }

    override fun buildModels() {
        buildImage(character.image)
        buildEpisode(character.episode)
        buildInfo(character)
    }

    private fun buildImage(image: String) {
        CharacterDetailsImageEpoxyModel(image).id(image).addTo(this)
    }

    private fun buildEpisode(episodes: List<String>) {
        val items = episodes.map { episode ->
            CharacterDetailsEpisodeEpoxyModel(episode).id(episode)
        }
        CarouselModel_().models(items).id("carousel_episode").addTo(this)
    }

    private fun buildInfo(character: Character) {
        CharacterDetailsInfoEpoxyModel(character).id(character.id).addTo(this)
    }
}