package com.demo.network.source

import com.demo.network.model.*

interface CharacterRemoteDataSource {
    suspend fun getAllCharacters(offset: Int, limit: Int) : List<MarvelCharacterDto>

    suspend fun getCharacterById(id : String) : MarvelCharacterDto

    suspend fun getCharacterComics(id : String) : List<CharacterComicDto>

    suspend fun getCharacterEvents(id : String) : List<CharacterEventDto>

    suspend fun getCharacterSeries(id : String) : List<CharacterSeriesDto>

    suspend fun getCharacterStories(id : String) : List<CharacterStoryDto>
}