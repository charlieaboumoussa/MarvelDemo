package com.demo.marveldemo.di

import com.demo.data.repository.character.CharacterRepository
import com.demo.data.repository.character.CharacterRepositoryImpl
import com.demo.network.source.CharacterRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import java.util.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideCharacterRepository(remoteDataSource: CharacterRemoteDataSourceImpl): CharacterRepository {
        return CharacterRepositoryImpl(remoteDataSource)
    }

}