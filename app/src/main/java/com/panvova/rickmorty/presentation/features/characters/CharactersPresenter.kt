package com.panvova.rickmorty.presentation.features.characters

import com.panvova.rickmorty.domain.usecase.GetCharactersUseCase
import com.panvova.rickmorty.domain.viewstate.CharacterViewState
import com.panvova.rickmorty.presentation.base.BasePresenter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CharactersPresenter(
    private val charactersUseCase: GetCharactersUseCase
) : BasePresenter<CharactersView>() {

    override fun loadData() {
        CoroutineScope(coroutineDispatcherIO).launch {
            view?.render(CharacterViewState.Loading)
            getEpisodes()
        }
    }

    private suspend fun getEpisodes() {
        charactersUseCase.getCharacters()
            .catch {
                withContext(coroutineDispatcherMain) {
                    view?.render(CharacterViewState.Error("Error"))
                }
            }
            .collect { characters ->
                withContext(coroutineDispatcherMain) {
                    view?.render(CharacterViewState.Success(characters))
                }
            }
    }
}