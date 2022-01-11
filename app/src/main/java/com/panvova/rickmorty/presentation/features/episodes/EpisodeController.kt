package com.panvova.rickmorty.presentation.features.episodes

import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import com.panvova.rickmorty.App
import com.panvova.rickmorty.databinding.EpisodesControllerBinding
import com.panvova.rickmorty.domain.model.Episode
import com.panvova.rickmorty.presentation.base.BaseController
import com.panvova.rickmorty.presentation.features.episodes.epoxy.EpisodeEpoxyController
import timber.log.Timber
import javax.inject.Inject

class EpisodeController :
    BaseController<EpisodesControllerBinding>(EpisodesControllerBinding::inflate), EpisodeView {

    @Inject
    protected lateinit var presenter: EpisodePresenter

    private val episodeEpoxyController = EpisodeEpoxyController()

    override fun onAttach(view: View) {
        super.onAttach(view)
        App.component.inject(this)
        presenter.attachView(this)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val dividerItemDecoration = DividerItemDecoration(activity, DividerItemDecoration.VERTICAL)
        binding.episodesRV.apply {
            setControllerAndBuildModels(episodeEpoxyController)
            addItemDecoration(dividerItemDecoration)
        }
    }

    override fun showEpisodes(episodes: List<Episode>) {
        episodeEpoxyController.episodes = episodes
    }

    override fun showError(throwable: Throwable) {
        Timber.e(throwable)
    }

    override fun onDestroyView(view: View) {
        super.onDestroyView(view)
        presenter.detachView(this)
    }
}