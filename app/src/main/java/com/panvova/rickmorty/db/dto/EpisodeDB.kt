package com.panvova.rickmorty.db.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "episodes")
data class EpisodeDB(
        @PrimaryKey val id: Int,
        val episode: String,
        val name: String
)