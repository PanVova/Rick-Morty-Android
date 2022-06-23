package com.panvova.rickmorty.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.panvova.rickmorty.db.dto.EpisodeDB

@Dao
interface EpisodeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(episodeDB: EpisodeDB)

    @Query("SELECT * FROM episodes")
    suspend fun getAll(): List<EpisodeDB>
}