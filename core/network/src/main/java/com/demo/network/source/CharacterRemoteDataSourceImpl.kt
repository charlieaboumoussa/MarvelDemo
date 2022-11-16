package com.demo.network.source

import com.demo.network.model.*
import com.demo.network.retrofit.CharacterNetworkService
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharacterRemoteDataSourceImpl @Inject constructor(
    private val characterNetworkApi: CharacterNetworkService
) : CharacterRemoteDataSource{

    override suspend fun getAllCharacters(offset: Int, limit: Int) : MutableList<MarvelCharacterDto>{
        return characterNetworkApi.getAllCharacters(offset, limit)
    }

    override suspend fun getCharacterById(id : String) : MarvelCharacterDto{
        return characterNetworkApi.getCharacterById(id)
    }

    override suspend fun getCharacterComics(id : String) : MutableList<CharacterComicDto>{
        return characterNetworkApi.getCharacterComics(id)
    }

    override suspend fun getCharacterEvents(id : String) : MutableList<CharacterEventDto>{
        return characterNetworkApi.getCharacterEvents(id)
    }

    override suspend fun getCharacterSeries(id : String) : MutableList<CharacterSeriesDto>{
        return characterNetworkApi.getCharacterSeries(id)
    }

    override suspend fun getCharacterStories(id : String) : MutableList<CharacterStoryDto>{
        return characterNetworkApi.getCharacterStories(id)
    }
}