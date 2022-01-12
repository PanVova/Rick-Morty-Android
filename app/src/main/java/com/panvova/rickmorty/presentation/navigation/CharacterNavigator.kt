package com.panvova.rickmorty.presentation.navigation

import com.panvova.rickmorty.domain.model.Character

interface CharacterNavigator {
    fun navigateToCharacterDetails(character: Character)
}