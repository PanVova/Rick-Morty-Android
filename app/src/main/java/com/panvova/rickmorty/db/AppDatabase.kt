package com.panvova.rickmorty.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.panvova.rickmorty.db.dao.CharacterDao
import com.panvova.rickmorty.db.dao.EpisodeDao
import com.panvova.rickmorty.db.dao.LocationDao
import com.panvova.rickmorty.db.dto.CharacterDB
import com.panvova.rickmorty.db.dto.EpisodeDB
import com.panvova.rickmorty.db.dto.LocationDB

@Database(entities = [CharacterDB::class, LocationDB::class, EpisodeDB::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
  abstract fun locationDao(): LocationDao
  abstract fun episodeDao(): EpisodeDao
  abstract fun characterDao(): CharacterDao
}