package com.demo.data.repository.character

import com.demo.model.*
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    suspend fun getAllCharacters(offset: Int, limit: Int) : Flow<List<MarvelCharacter>>

    suspend fun deleteAllCharacters()

    suspend fun getCharacterById(id : Int) : Flow<MarvelCharacter>

    suspend fun getCharacterComics(id : Int, offset: Int, limit: Int) : Flow<List<CharacterComic>>

    suspend fun getCharacterEvents(id : Int, offset: Int, limit: Int) : Flow<List<CharacterEvent>>

    suspend fun getCharacterSeries(id : Int, offset: Int, limit: Int) : Flow<List<CharacterSeries>>

    suspend fun getCharacterStories(id : Int, offset: Int, limit: Int) : Flow<List<CharacterStory>>
}