package com.panvova.rickmorty.data.dto.character

data class CharacterResult(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: CharacterInfo,
    val name: String,
    val origin: CharacterInfo,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)