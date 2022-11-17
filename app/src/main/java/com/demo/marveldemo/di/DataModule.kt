package com.demo.marveldemo.di

import com.demo.network.retrofit.CharacterNetworkService
import com.demo.network.source.CharacterRemoteDataSource
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
    fun provideCharacterRemoteDataSource(characterNetworkApi: CharacterNetworkService): CharacterRemoteDataSource {
        return CharacterRemoteDataSourceImpl(characterNetworkApi)
    }

}