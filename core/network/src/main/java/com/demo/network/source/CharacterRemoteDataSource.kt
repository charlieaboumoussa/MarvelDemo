package com.demo.network.source

import com.demo.network.model.*

interface CharacterRemoteDataSource {
    suspend fun getAllCharacters(offset: Int, limit: Int) : List<MarvelCharacterDto>

    suspend fun getCharacterById(id : Int) : MarvelCharacterDto?

    suspend fun getCharacterComics(id : Int,offset: Int, limit: Int) : List<CharacterComicDto>

    suspend fun getCharacterEvents(id : Int,offset: Int, limit: Int) : List<CharacterEventDto>

    suspend fun getCharacterSeries(id : Int,offset: Int, limit: Int) : List<CharacterSeriesDto>

    suspend fun getCharacterStories(id : Int,offset: Int, limit: Int) : List<CharacterStoryDto>
}