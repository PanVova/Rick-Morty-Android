package com.panvova.rickmorty.domain.usecase

import com.panvova.rickmorty.data.dto.location.LocationResult
import com.panvova.rickmorty.domain.gateway.RickMortyGateway
import kotlinx.coroutines.flow.Flow

class GetLocationsUseCase(private val rickMortyGateway: RickMortyGateway) {
    fun getLocations(): Flow<LocationResult> {
        return rickMortyGateway.getLocations()
    }
}