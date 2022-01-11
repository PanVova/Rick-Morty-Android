package com.panvova.rickmorty.domain.model

data class Character(
    val gender: String,
    val image: String,
    val name: String,
    val species: String,
    val status: String
)