package com.panvova.rickmorty.db.dao

import androidx.room.*
import com.panvova.rickmorty.db.dto.CharacterDB

@Dao
interface CharacterDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(characterDB: CharacterDB)

    @Query("SELECT * FROM characters")
    suspend fun getAll(): List<CharacterDB>
}