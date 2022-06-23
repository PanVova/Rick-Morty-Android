package com.panvova.rickmorty.presentation.features.characters

import com.panvova.rickmorty.domain.viewstate.CharacterViewState
import com.panvova.rickmorty.presentation.base.BaseView

interface CharactersView : BaseView {
    fun render(state: CharacterViewState)
}