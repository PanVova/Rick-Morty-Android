package com.panvova.rickmorty.data

import com.panvova.rickmorty.data.dto.base.BaseResponse
import com.panvova.rickmorty.data.dto.character.CharacterResult
import com.panvova.rickmorty.data.dto.episode.EpisodeResult
import com.panvova.rickmorty.data.dto.location.LocationResult
import retrofit2.http.GET

interface RickMortyAPI {
    @GET("character")
    suspend fun getCharacters(): BaseResponse<CharacterResult>

    @GET("location")
    suspend fun getLocations(): BaseResponse<LocationResult>

    @GET("episode")
    suspend fun getEpisodes(): BaseResponse<EpisodeResult>
}