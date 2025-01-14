package com.panvova.rickmorty.data.dto.episode

data class EpisodeResult(
  val air_date: String,
  val characters: List<String>,
  val created: String,
  val episode: String,
  val id: Int,
  val name: String,
  val url: String
)