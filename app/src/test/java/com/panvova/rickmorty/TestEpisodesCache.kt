package com.panvova.rickmorty

import com.panvova.rickmorty.db.dao.EpisodeDao
import com.panvova.rickmorty.db.dto.EpisodeDB

class TestEpisodesCache : EpisodeDao {
    private var inMemoryCache = mutableListOf<EpisodeDB>()
    override fun insert(episodeDB: EpisodeDB) {
        inMemoryCache.add(episodeDB)
    }

    override suspend fun getAll(): List<EpisodeDB> {
        return inMemoryCache
    }
}