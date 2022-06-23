package com.panvova.rickmorty.domain.usecase

import com.panvova.rickmorty.domain.gateway.RickMortyGateway
import com.panvova.rickmorty.domain.model.Character
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(private val rickMortyGateway: RickMortyGateway) {
    fun getCharacters(): Flow<List<Character>> {
        return rickMortyGateway.getCharacters()
    }
}