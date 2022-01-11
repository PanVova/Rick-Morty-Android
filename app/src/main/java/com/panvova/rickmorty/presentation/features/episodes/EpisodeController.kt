package com.panvova.rickmorty.presentation.features.episodes

import android.view.View
import com.panvova.rickmorty.databinding.EpisodesControllerBinding
import com.panvova.rickmorty.presentation.base.BaseController

class EpisodeController :
    BaseController<EpisodesControllerBinding>(EpisodesControllerBinding::inflate) {

    private val episodeEpoxyController = EpisodeEpoxyController()

    override fun onAttach(view: View) {
        super.onAttach(view)
        binding.episodesRV.setControllerAndBuildModels(episodeEpoxyController)
    }
}