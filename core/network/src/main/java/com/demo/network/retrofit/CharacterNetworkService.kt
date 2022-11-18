package com.demo.network.retrofit

import com.demo.network.model.*
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterNetworkService {

    @GET(value = "characters")
    suspend fun getAllCharacters(@Query("offset") offset: Int, @Query("limit") limit :Int) : List<MarvelCharacterDto>

    @GET(value = "characters/{characterId}")
    suspend fun getCharacterById(@Path("characterId") id : String) : MarvelCharacterDto

    @GET(value = "characters/{characterId}/comics")
    suspend fun getCharacterComics(@Path("characterId") id : String) : List<CharacterComicDto>

    @GET(value = "characters/{characterId}/events")
    suspend fun getCharacterEvents(@Path("characterId") id : String) : List<CharacterEventDto>

    @GET(value = "characters/{characterId}/series")
    suspend fun getCharacterSeries(@Path("characterId") id : String) : List<CharacterSeriesDto>

    @GET(value = "characters/{characterId}/stories")
    suspend fun getCharacterStories(@Path("characterId") id : String) : List<CharacterStoryDto>



}