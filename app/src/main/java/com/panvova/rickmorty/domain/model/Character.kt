package com.panvova.rickmorty.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Character(
    val id: Int,
    val episode: List<String>,
    val gender: String,
    val image: String,
    val name: String,
    val species: String,
    val status: String,
) {
    constructor() : this(-1, emptyList(), "", "", "", "", "")
}