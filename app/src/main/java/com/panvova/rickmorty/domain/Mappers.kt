package com.panvova.rickmorty.domain

import com.panvova.rickmorty.data.dto.character.CharacterResult
import com.panvova.rickmorty.data.dto.episode.EpisodeResult
import com.panvova.rickmorty.data.dto.location.LocationResult
import com.panvova.rickmorty.domain.model.Character
import com.panvova.rickmorty.domain.model.Episode
import com.panvova.rickmorty.domain.model.Location

fun CharacterResult.toDomain(): Character {
    return Character(id, gender, image, name, species, status)
}

fun EpisodeResult.toDomain(): Episode {
    return Episode(episode, id, name)
}

fun LocationResult.toDomain(): Location {
    return Location(dimension, id, name, type)
}