package com.demo.data.repository.character

import com.demo.data.mappers.toEntityModel
import com.demo.model.*
import com.demo.network.source.CharacterRemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharacterRepositoryImpl @Inject constructor(
    private val characterRemoteDataSource : CharacterRemoteDataSource
) : CharacterRepository {
    override suspend fun getAllCharacters(offset: Int, limit: Int): Flow<List<MarvelCharacter>> = flow{
        emit(
            characterRemoteDataSource.getAllCharacters(offset, limit).map {
                it.toEntityModel()
            }.toMutableList()
        )
    }

    override suspend fun getCharacterById(id: String): Flow<MarvelCharacter> = flow{
        emit(
            characterRemoteDataSource.getCharacterById(id).toEntityModel()
        )
    }

    override suspend fun getCharacterComics(id: String): Flow<List<CharacterComic>> = flow{
        emit(
            characterRemoteDataSource.getCharacterComics(id).map {
                it.toEntityModel()
            }.toMutableList()
        )
    }

    override suspend fun getCharacterEvents(id: String): Flow<List<CharacterEvent>> = flow{
        emit(
            characterRemoteDataSource.getCharacterEvents(id).map {
                it.toEntityModel()
            }.toMutableList()
        )
    }

    override suspend fun getCharacterSeries(id: String): Flow<List<CharacterSeries>> = flow{
        emit(
            characterRemoteDataSource.getCharacterSeries(id).map {
                it.toEntityModel()
            }.toMutableList()
        )
    }

    override suspend fun getCharacterStories(id: String): Flow<List<CharacterStory>> = flow{
        emit(
            characterRemoteDataSource.getCharacterStories(id).map {
                it.toEntityModel()
            }.toMutableList()
        )
    }

}