package com.panvova.rickmorty.domain.viewstate

import com.panvova.rickmorty.domain.model.Character

sealed class CharacterViewState {
    object Loading : CharacterViewState()
    data class Success(val characters: List<Character>) : CharacterViewState()
    data class Error(val error: String) : CharacterViewState()
}