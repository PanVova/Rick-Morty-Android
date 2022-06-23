package com.panvova.rickmorty.db.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "characters")
data class CharacterDB(
    @PrimaryKey val id: Int,
    val episodes: List<String>,
    val gender: String,
    val image: String,
    val name: String,
    val species: String,
    val status: String,
)