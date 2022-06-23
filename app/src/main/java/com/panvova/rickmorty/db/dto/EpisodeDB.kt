package com.panvova.rickmorty.db.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class EpisodeDB(
  @PrimaryKey val id: Int,
  val air_date: String,
  val characters: List<String>,
  val created: String,
  val episode: String,
  val name: String,
  val url: String
)