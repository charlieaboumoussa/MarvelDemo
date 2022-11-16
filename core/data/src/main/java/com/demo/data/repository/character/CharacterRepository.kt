package com.demo.data.repository.character

import com.demo.model.*
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    suspend fun getAllCharacters(offset: Int, limit: Int) : Flow<MutableList<MarvelCharacter>>

    suspend fun getCharacterById(id : String) : Flow<MarvelCharacter>

    suspend fun getCharacterComics(id : String) : Flow<MutableList<CharacterComic>>

    suspend fun getCharacterEvents(id : String) : Flow<MutableList<CharacterEvent>>

    suspend fun getCharacterSeries(id : String) : Flow<MutableList<CharacterSeries>>

    suspend fun getCharacterStories(id : String) : Flow<MutableList<CharacterStory>>
}