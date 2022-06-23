package com.panvova.rickmorty

import com.panvova.rickmorty.db.dao.LocationDao
import com.panvova.rickmorty.db.dto.LocationDB

class TestLocationsCache : LocationDao {
    private var inMemoryCache = mutableListOf<LocationDB>()
    override fun insert(locationDB: LocationDB) {
        inMemoryCache.add(locationDB)
    }

    override suspend fun getAll(): List<LocationDB> {
        return inMemoryCache
    }
}

