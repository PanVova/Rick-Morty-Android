package com.panvova.rickmorty.presentation.features.locations

import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import com.panvova.rickmorty.App
import com.panvova.rickmorty.databinding.LocationsControllerBinding
import com.panvova.rickmorty.domain.model.Location
import com.panvova.rickmorty.domain.viewstate.LocationViewState
import com.panvova.rickmorty.presentation.base.BaseController
import com.panvova.rickmorty.presentation.features.locations.epoxy.LocationEpoxyController
import timber.log.Timber
import javax.inject.Inject

class LocationController :
    BaseController<LocationsControllerBinding>(LocationsControllerBinding::inflate), LocationView {

    @Inject
    protected lateinit var presenter: LocationPresenter
    private val locationEpoxyController = LocationEpoxyController()

    override fun onAttach(view: View) {
        super.onAttach(view)
        App.component.inject(this)
        presenter.attachView(this)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val dividerItemDecoration = DividerItemDecoration(activity, DividerItemDecoration.VERTICAL)
        binding.locationsRV.apply {
            setControllerAndBuildModels(locationEpoxyController)
            addItemDecoration(dividerItemDecoration)
        }
    }

    override fun render(state: LocationViewState) {
        when (state) {
            is LocationViewState.Success -> showLocations(state.locations)
            is LocationViewState.Loading -> showLoading()
            is LocationViewState.Error -> showError(state.error)
        }
    }

    private fun showLocations(locations: List<Location>) {
        binding.locationsRV.visibility = View.VISIBLE
        binding.progressBar.visibility = View.GONE
        locationEpoxyController.locations = locations
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