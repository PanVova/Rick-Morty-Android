package com.panvova.rickmorty.domain.usecase

import com.panvova.rickmorty.data.dto.character.CharacterResult
import com.panvova.rickmorty.domain.gateway.RickMortyGateway
import kotlinx.coroutines.flow.Flow

class GetCharactersUseCase(private val rickMortyGateway: RickMortyGateway) {
    fun getCharacters(): Flow<CharacterResult> {
        return rickMortyGateway.getCharacters()
    }
}