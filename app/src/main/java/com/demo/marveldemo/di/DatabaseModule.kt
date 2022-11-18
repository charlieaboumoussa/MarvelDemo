package com.demo.marveldemo.di

import android.content.Context
import androidx.room.Room
import com.demo.database.Database
import com.demo.database.dao.MarvelCharacterDao
import com.demo.network.source.CharacterLocalDataSource
import com.demo.network.source.CharacterLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    private const val DATABASE_NAME = "APP_DATABASE"

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context : Context): Database {
        return Room.databaseBuilder(context, Database::class.java, DATABASE_NAME)
//                .addMigrations()
                .build()
    }

    @Singleton
    @Provides
    fun provideMarvelCharacterDao(
        database: Database
    ): MarvelCharacterDao {
        return database.marvelCharacterDao()
    }

    @Singleton
    @Provides
    fun provideCharacterLocalDataSource(
        dao: MarvelCharacterDao
    ): CharacterLocalDataSource {
        return CharacterLocalDataSourceImpl(dao)
    }
}