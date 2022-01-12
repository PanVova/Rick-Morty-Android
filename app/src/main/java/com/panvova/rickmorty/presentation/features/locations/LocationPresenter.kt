package com.panvova.rickmorty.presentation.features.locations

import com.panvova.rickmorty.domain.usecase.GetLocationsUseCase
import com.panvova.rickmorty.domain.viewstate.LocationViewState
import com.panvova.rickmorty.presentation.base.BasePresenter
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Named

class LocationPresenter @Inject constructor(
    private val locationsUseCase: GetLocationsUseCase,
    @Named("Main") private val coroutineDispatcherMain: CoroutineDispatcher,
    @Named("IO") private val coroutineDispatcherIO: CoroutineDispatcher,
) : BasePresenter<LocationView>() {

    override fun attachView(view: LocationView) {
        super.attachView(view)
        loadLocations()
    }

    private fun loadLocations() {
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