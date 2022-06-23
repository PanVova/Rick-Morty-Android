package com.panvova.rickmorty.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.panvova.rickmorty.db.dto.LocationDB

@Dao
interface LocationDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(locationDB: LocationDB)

    @Query("SELECT * FROM locationdb")
    suspend fun getAll(): List<LocationDB>
}