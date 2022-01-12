package com.panvova.rickmorty.presentation.features.episodes

import com.panvova.rickmorty.domain.viewstate.EpisodeViewState
import com.panvova.rickmorty.presentation.base.BaseView

interface EpisodeView : BaseView {
    fun render(state: EpisodeViewState)
}