package com.demo.network.source

import com.demo.database.model.MarvelCharacterDB
import kotlinx.coroutines.flow.Flow

interface CharacterLocalDataSource {
    suspend fun addAllCharacters(characters: List<MarvelCharacterDB>)

    suspend fun deleteAllCharacters()

    suspend fun getAllCharacters() : Flow<List<MarvelCharacterDB>>

    suspend fun getCharacterById(id : Int) : Flow<MarvelCharacterDB>

}