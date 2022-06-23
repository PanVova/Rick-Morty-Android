package com.panvova.rickmorty.domain

import com.panvova.rickmorty.data.dto.character.CharacterResult
import com.panvova.rickmorty.data.dto.episode.EpisodeResult
import com.panvova.rickmorty.data.dto.location.LocationResult
import com.panvova.rickmorty.db.dto.CharacterDB
import com.panvova.rickmorty.db.dto.EpisodeDB
import com.panvova.rickmorty.db.dto.LocationDB
import com.panvova.rickmorty.domain.model.Character
import com.panvova.rickmorty.domain.model.Episode
import com.panvova.rickmorty.domain.model.Location

fun CharacterResult.toDB(): CharacterDB {
    return CharacterDB(
            id = id,
            episodes = episode,
            gender = gender,
            image = image,
            name = name,
            species = species,
            status = status
    )
}

fun CharacterDB.toDomain(): Character {
    return Character(
            id = id,
            episode = episodes,
            gender = gender,
            image = image,
            name = name,
            species = species,
            status = status
    )
}

fun EpisodeResult.toDB(): EpisodeDB {
    return EpisodeDB(
            episode = episode,
            id = id,
            name = name
    )
}

fun EpisodeDB.toDomain(): Episode {
    return Episode(
            episode = episode,
            id = id,
            name = name
    )
}

fun LocationResult.toDB(): LocationDB {
    return LocationDB(
            dimension = dimension,
            id = id,
            name = name,
            type = type
    )
}

fun LocationDB.toDomain(): Location {
    return Location(
            dimension = dimension,
            id = id,
            name = name,
            type = type
    )
}