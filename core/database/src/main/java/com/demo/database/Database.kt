package com.demo.database

import androidx.room.Database
import androidx.room.TypeConverters
import androidx.room.RoomDatabase
import com.demo.database.converters.StringListConverter
import com.demo.database.dao.MarvelCharacterDao
import com.demo.database.model.*

@Database(
    version = 1,
    entities = [
        CharacterComicDB::class,
        CharacterEventDB::class,
        CharacterSeriesDB::class,
        CharacterStoryDB::class,
        MarvelCharacterDB::class,
    ])
@TypeConverters(StringListConverter::class)
abstract class Database : RoomDatabase() {

    abstract fun marvelCharacterDao() : MarvelCharacterDao

}