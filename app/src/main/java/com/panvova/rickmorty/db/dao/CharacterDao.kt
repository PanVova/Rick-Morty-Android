package com.panvova.rickmorty.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.panvova.rickmorty.db.dto.CharacterDB

@Dao
interface CharacterDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(characterDB: CharacterDB)

    @Query("SELECT * FROM characterdb")
    suspend fun getAll(): List<CharacterDB>
}