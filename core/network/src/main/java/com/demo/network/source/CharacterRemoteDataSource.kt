package com.demo.network.source

import com.demo.network.model.*

interface CharacterRemoteDataSource {
    suspend fun getAllCharacters(offset: Int, limit: Int) : MutableList<MarvelCharacterDto>

    suspend fun getCharacterById(id : String) : MarvelCharacterDto

    suspend fun getCharacterComics(id : String) : MutableList<CharacterComicDto>

    suspend fun getCharacterEvents(id : String) : MutableList<CharacterEventDto>

    suspend fun getCharacterSeries(id : String) : MutableList<CharacterSeriesDto>

    suspend fun getCharacterStories(id : String) : MutableList<CharacterStoryDto>
}