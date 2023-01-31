package com.panvova.rickmorty.di

import androidx.room.Room
import com.panvova.rickmorty.db.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(androidApplication(), AppDatabase::class.java, "local-storage")
            .build()
    }

    single { get<AppDatabase>().characterDao() }
    single { get<AppDatabase>().episodeDao() }
    single { get<AppDatabase>().locationDao() }
}