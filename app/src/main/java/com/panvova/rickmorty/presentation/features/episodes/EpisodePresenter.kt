package com.panvova.rickmorty.presentation.features.episodes

import com.panvova.rickmorty.domain.usecase.GetEpisodesUseCase
import com.panvova.rickmorty.domain.viewstate.EpisodeViewState
import com.panvova.rickmorty.presentation.base.BasePresenter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class EpisodePresenter @Inject constructor(
    private val episodesUseCase: GetEpisodesUseCase,
) : BasePresenter<EpisodeView>() {

    override fun loadData() {
        CoroutineScope(coroutineDispatcherIO).launch {
            view?.render(EpisodeViewState.Loading)
            getEpisodes()
        }
    }

    private suspend fun getEpisodes() {
        episodesUseCase.getEpisodes()
            .catch {
                withContext(coroutineDispatcherMain) {
                    view?.render(EpisodeViewState.Error("Error"))
                }
            }
            .collect { episodes ->
                withContext(coroutineDispatcherMain) {
                    view?.render(EpisodeViewState.Success(episodes))
                }
            }
    }
}