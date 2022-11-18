package com.demo.data.repository.character

import com.demo.data.mappers.toEntityModel
import com.demo.database.mappers.toDbModel
import com.demo.database.mappers.toEntityModel
import com.demo.model.*
import com.demo.network.source.CharacterLocalDataSource
import com.demo.network.source.CharacterRemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharacterRepositoryImpl @Inject constructor(
    private val characterRemoteDataSource : CharacterRemoteDataSource,
    private val characterLocalDataSource : CharacterLocalDataSource,
) : CharacterRepository {

    override suspend fun getAllCharacters(offset: Int, limit: Int): Flow<List<MarvelCharacter>> {
        val characters = characterRemoteDataSource.getAllCharacters(offset, limit).map {
            it.toEntityModel()
        }.toMutableList()
        characterLocalDataSource.addAllCharacters(characters.map { it.toDbModel() }.toList())
        return characterLocalDataSource.getAllCharacters().map {
            it.map {
                it.toEntityModel()
            }
        }
    }

    override suspend fun deleteAllCharacters() {
        characterLocalDataSource.deleteAllCharacters()
    }

    override suspend fun getCharacterById(id: Int): Flow<MarvelCharacter>{
        return characterLocalDataSource.getCharacterById(id).map { it.toEntityModel() }
    }

    override suspend fun getCharacterComics(id: Int,offset: Int, limit: Int): Flow<List<CharacterComic>> = flow{
        emit(
            characterRemoteDataSource.getCharacterComics(id, offset, limit).map {
                it.toEntityModel()
            }.toMutableList()
        )
    }

    override suspend fun getCharacterEvents(id: Int,offset: Int, limit: Int): Flow<List<CharacterEvent>> = flow{
        emit(
            characterRemoteDataSource.getCharacterEvents(id, offset, limit).map {
                it.toEntityModel()
            }.toMutableList()
        )
    }

    override suspend fun getCharacterSeries(id: Int,offset: Int, limit: Int): Flow<List<CharacterSeries>> = flow{
        emit(
            characterRemoteDataSource.getCharacterSeries(id, offset, limit).map {
                it.toEntityModel()
            }.toMutableList()
        )
    }

    override suspend fun getCharacterStories(id: Int,offset: Int, limit: Int): Flow<List<CharacterStory>> = flow{
        emit(
            characterRemoteDataSource.getCharacterStories(id, offset, limit).map {
                it.toEntityModel()
            }.toMutableList()
        )
    }

}