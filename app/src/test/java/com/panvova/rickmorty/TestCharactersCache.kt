package com.panvova.rickmorty

import com.panvova.rickmorty.db.dao.CharacterDao
import com.panvova.rickmorty.db.dto.CharacterDB

class TestCharactersCache : CharacterDao {

    private var inMemoryCache = mutableListOf<CharacterDB>()
    override fun insert(characterDB: CharacterDB) {
        inMemoryCache.add(characterDB)
    }

    override suspend fun getAll(): List<CharacterDB> {
        return inMemoryCache
    }
}