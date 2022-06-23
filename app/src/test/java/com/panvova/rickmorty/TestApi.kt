package com.panvova.rickmorty

import com.panvova.rickmorty.data.RickMortyAPI
import com.panvova.rickmorty.data.dto.base.BaseResponse
import com.panvova.rickmorty.data.dto.base.Info
import com.panvova.rickmorty.data.dto.character.CharacterInfo
import com.panvova.rickmorty.data.dto.character.CharacterResult
import com.panvova.rickmorty.data.dto.episode.EpisodeResult
import com.panvova.rickmorty.data.dto.location.LocationResult

class TestApi : RickMortyAPI {
    override suspend fun getCharacters(): BaseResponse<CharacterResult> {
        return BaseResponse(
            Info(0, "", 0, ""),
            listOf(CharacterResult(
                created = "",
                episode = listOf(),
                gender = "",
                id = 1,
                image = "",
                location = CharacterInfo(name = "", url = ""),
                name = "",
                origin = CharacterInfo(name = "", url = ""),
                species = "",
                status = "",
                type = "",
                url = ""
            ))
        )
    }

    override suspend fun getLocations(): BaseResponse<LocationResult> {
        return BaseResponse(
            Info(0, "", 0, ""),
            listOf(LocationResult(
                created = "",
                dimension = "",
                id = 1,
                name = "",
                residents = listOf(),
                type = "",
                url = "")
            )
        )
    }

    override suspend fun getEpisodes(): BaseResponse<EpisodeResult> {
        return BaseResponse(
            Info(0, "", 0, ""),
            listOf(EpisodeResult(
                air_date = "",
                characters = listOf(),
                created = "",
                episode = "",
                id = 1,
                name = "",
                url = ""
            ))
        )
    }
}