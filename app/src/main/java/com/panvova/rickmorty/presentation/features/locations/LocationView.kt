package com.panvova.rickmorty.presentation.features.locations

import com.panvova.rickmorty.domain.viewstate.LocationViewState
import com.panvova.rickmorty.presentation.base.BaseView

interface LocationView : BaseView {
    fun render(state: LocationViewState)
}