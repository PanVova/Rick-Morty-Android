package com.panvova.rickmorty.presentation.features.locations

import com.panvova.rickmorty.domain.usecase.GetLocationsUseCase
import com.panvova.rickmorty.domain.viewstate.LocationViewState
import com.panvova.rickmorty.presentation.base.BasePresenter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LocationPresenter @Inject constructor(
    private val locationsUseCase: GetLocationsUseCase,
) : BasePresenter<LocationView>() {

    override fun loadData() {
        CoroutineScope(coroutineDispatcherIO).launch {
            view?.render(LocationViewState.Loading)
            getLocations()
        }
    }

    private suspend fun getLocations() {
        locationsUseCase.getLocations()
            .catch {
                withContext(coroutineDispatcherMain) {
                    view?.render(LocationViewState.Error("Error"))
                }
            }.collect { locations ->
                withContext(coroutineDispatcherMain) {
                    view?.render(LocationViewState.Success(locations))
                }
            }
    }
}