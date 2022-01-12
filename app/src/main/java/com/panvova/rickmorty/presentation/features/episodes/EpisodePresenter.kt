package com.panvova.rickmorty.presentation.features.episodes

import com.panvova.rickmorty.domain.usecase.GetEpisodesUseCase
import com.panvova.rickmorty.presentation.base.BasePresenter
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class EpisodePresenter @Inject constructor(
    private val episodesUseCase: GetEpisodesUseCase,
    private val coroutineDispatcher: CoroutineDispatcher
) : BasePresenter<EpisodeView>() {

    override fun attachView(view: EpisodeView) {
        super.attachView(view)
        loadEpisodes()
    }

    private fun loadEpisodes() {
        CoroutineScope(coroutineDispatcher).launch {
            episodesUseCase.getEpisodes().collect { episodes ->
                view?.showEpisodes(episodes)
            }
        }
    }
}