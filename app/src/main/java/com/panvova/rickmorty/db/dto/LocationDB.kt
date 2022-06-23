package com.panvova.rickmorty.db.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class LocationDB(
  @PrimaryKey val id: Int,
  val created: String,
  val dimension: String,
  val name: String,
  val residents: List<String>,
  val type: String,
  val url: String
)