package com.panvova.rickmorty.domain.usecase

import com.panvova.rickmorty.domain.gateway.RickMortyGateway
import com.panvova.rickmorty.domain.model.Location
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetLocationsUseCase @Inject constructor(private val rickMortyGateway: RickMortyGateway) {
    fun getLocations(): Flow<List<Location>> {
        return rickMortyGateway.getLocations()
    }
}