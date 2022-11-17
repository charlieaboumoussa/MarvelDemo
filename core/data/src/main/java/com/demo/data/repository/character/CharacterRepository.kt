package com.demo.data.repository.character

import com.demo.model.*
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    suspend fun getAllCharacters(offset: Int, limit: Int) : Flow<List<MarvelCharacter>>

    suspend fun getCharacterById(id : String) : Flow<MarvelCharacter>

    suspend fun getCharacterComics(id : String) : Flow<List<CharacterComic>>

    suspend fun getCharacterEvents(id : String) : Flow<List<CharacterEvent>>

    suspend fun getCharacterSeries(id : String) : Flow<List<CharacterSeries>>

    suspend fun getCharacterStories(id : String) : Flow<List<CharacterStory>>
}