package com.demo.network.source

import com.demo.database.dao.MarvelCharacterDao
import com.demo.database.model.MarvelCharacterDB
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharacterLocalDataSourceImpl @Inject constructor(
    private val characterDao: MarvelCharacterDao
) : CharacterLocalDataSource {

    override suspend fun addAllCharacters(characters: List<MarvelCharacterDB>) {
       characterDao.insert(characters)
    }

    override suspend fun deleteAllCharacters() {
        characterDao.nuke()
    }

    override suspend fun getAllCharacters(): Flow<List<MarvelCharacterDB>> {
        return characterDao.flowCharacters()
    }

    override suspend fun getCharacterById(id: Int): Flow<MarvelCharacterDB> = flow {
        val characterByIdList = characterDao.getCharacterById(id)
        if (characterByIdList.isNotEmpty()) {
            emit(
                characterByIdList.first()
            )
        }
    }
}