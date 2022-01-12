package com.panvova.rickmorty.domain.viewstate

import com.panvova.rickmorty.domain.model.Location

sealed class LocationViewState {
    object Loading : LocationViewState()
    data class Success(val locations: List<Location>) : LocationViewState()
    data class Error(val error: String) : LocationViewState()
}