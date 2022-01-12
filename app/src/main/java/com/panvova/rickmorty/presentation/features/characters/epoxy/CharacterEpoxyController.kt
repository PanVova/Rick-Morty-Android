package com.panvova.rickmorty.presentation.features.characters.epoxy

import com.airbnb.epoxy.EpoxyController
import com.panvova.rickmorty.domain.model.Character

class CharacterEpoxyController : EpoxyController() {

    var characters: List<Character> = listOf()
        set(value) {
            field = value
            requestModelBuild()
        }

    override fun buildModels() {
        characters.forEach { character ->
            buildCharacter(character)
        }
    }

    private fun buildCharacter(character: Character) {
        CharacterEpoxyModel(character).id(character.id).addTo(this)
    }
}