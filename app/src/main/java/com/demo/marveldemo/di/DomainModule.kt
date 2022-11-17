package com.demo.marveldemo.di

import com.demo.data.repository.character.CharacterRepository
import com.demo.data.repository.character.CharacterRepositoryImpl
import com.demo.domain.usecases.GetAllMarvelCharactersUseCase
import com.demo.network.source.CharacterRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import java.util.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    @Singleton
    fun provideGetAllMarvelCharactersUseCase(repository: CharacterRepository): GetAllMarvelCharactersUseCase {
        return GetAllMarvelCharactersUseCase(repository)
    }

}