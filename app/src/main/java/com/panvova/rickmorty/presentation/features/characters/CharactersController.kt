package com.panvova.rickmorty.presentation.features.characters

import android.view.View
import com.panvova.rickmorty.App
import com.panvova.rickmorty.databinding.EpisodesControllerBinding
import com.panvova.rickmorty.domain.model.Character
import com.panvova.rickmorty.domain.viewstate.CharacterViewState
import com.panvova.rickmorty.presentation.base.BaseController
import com.panvova.rickmorty.presentation.features.characters.epoxy.CharacterEpoxyController
import com.panvova.rickmorty.presentation.navigation.CharacterNavigator
import timber.log.Timber
import javax.inject.Inject

class CharactersController :
    BaseController<EpisodesControllerBinding>(EpisodesControllerBinding::inflate), CharactersView {

    @Inject
    protected lateinit var presenter: CharactersPresenter
    private val characterEpoxyController = CharacterEpoxyController() {
        (activity as CharacterNavigator).navigateToCharacterDetails(it)
    }

    override fun onAttach(view: View) {
        super.onAttach(view)
        App.component.inject(this)
        presenter.attachView(this)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.episodesRV.setControllerAndBuildModels(characterEpoxyController)
    }

    override fun render(state: CharacterViewState) {
        when (state) {
            is CharacterViewState.Success -> showCharacters(state.characters)
            is CharacterViewState.Loading -> showLoading()
            is CharacterViewState.Error -> showError(state.error)
        }
    }

    private fun showCharacters(characters: List<Character>) {
        binding.episodesRV.visibility = View.VISIBLE
        binding.progressBar.visibility = View.GONE
        characterEpoxyController.characters = characters
    }

    private fun showLoading() {
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun showError(error: String) {
        Timber.e(error)
        binding.progressBar.visibility = View.GONE
        binding.error.visibility = View.VISIBLE
    }

    override fun onDestroyView(view: View) {
        presenter.detachView(this)
        super.onDestroyView(view)
    }
}