package com.demo.marveldemo.di

import com.demo.data.repository.character.CharacterRepository
import com.demo.domain.usecases.*
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

    @Provides
    @Singleton
    fun provideGetMarvelCharacterByIdUseCase(repository: CharacterRepository): GetMarvelCharacterByIdUseCase {
        return GetMarvelCharacterByIdUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetAllCharacterStoriesByIdUseCase(repository: CharacterRepository): GetAllCharacterStoriesByIdUseCase {
        return GetAllCharacterStoriesByIdUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetAllCharacterSeriesByIdUseCase(repository: CharacterRepository): GetAllCharacterSeriesByIdUseCase {
        return GetAllCharacterSeriesByIdUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetAllCharacterEventsByIdUseCase(repository: CharacterRepository): GetAllCharacterEventsByIdUseCase {
        return GetAllCharacterEventsByIdUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetAllCharacterComicsByIdUseCase(repository: CharacterRepository): GetAllCharacterComicsByIdUseCase {
        return GetAllCharacterComicsByIdUseCase(repository)
    }

}