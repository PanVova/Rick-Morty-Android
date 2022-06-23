package com.panvova.rickmorty.db.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CharacterDB(
    @PrimaryKey val id: Int,
    val created: String,
    val episode: List<String>,
    val gender: String,
    val image: String,
    val location: CharacterInfoDB,
    val name: String,
    val origin: CharacterInfoDB,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)