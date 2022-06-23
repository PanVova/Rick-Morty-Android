package com.panvova.rickmorty

import com.panvova.rickmorty.data.gatewayImpl.RickMortyGatewayImpl
import com.panvova.rickmorty.domain.model.Character
import com.panvova.rickmorty.domain.model.Episode
import com.panvova.rickmorty.domain.model.Location
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class GatewayTest {
    private val api = TestApi()
    private val gatewayTest = RickMortyGatewayImpl(
        rickMortyAPI = api,
        characterDao = TestCharactersCache(),
        episodeDao = TestEpisodesCache(),
        locationDao = TestLocationsCache()
    )


    @Test
    fun checkGetCharacters() = runBlocking {
        var characters: List<Character> = listOf()
        gatewayTest.getCharacters().collect {
            characters = it
        }
        assertEquals(
                listOf(
                Character(
                    id = 1,
                    episode = listOf(),
                    gender = "",
                    image = "",
                    name = "",
                    species = "",
                    status = ""
                )
            ),
            characters)
    }

    @Test
    fun checkGetLocations() = runBlocking {
        var locations: List<Location> = listOf()
        gatewayTest.getLocations().collect {
            locations = it
        }
        assertEquals(
            listOf(
                Location(
                    dimension = "",
                    id = 1,
                    name = "",
                    type = ""
                )
            ),
            locations)
    }

    @Test
    fun checkGetEpisodes() = runBlocking {
        var episodes: List<Episode> = listOf()
        gatewayTest.getEpisodes().collect {
            episodes = it
        }
        assertEquals(
            listOf(
                Episode(
                    episode = "",
                    id = 1,
                    name = ""
                )
            ),
            episodes)
    }
}