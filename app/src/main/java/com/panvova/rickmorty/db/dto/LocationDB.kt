package com.panvova.rickmorty.db.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "locations")
data class LocationDB(
        @PrimaryKey val id: Int,
        val dimension: String,
        val name: String,
        val type: String
)