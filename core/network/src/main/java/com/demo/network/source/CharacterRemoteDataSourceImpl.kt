package com.demo.network.source

import com.demo.network.model.*
import com.demo.network.retrofit.CharacterNetworkService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharacterRemoteDataSourceImpl @Inject constructor(
    private val characterNetworkApi: CharacterNetworkService
) : CharacterRemoteDataSource {

    override suspend fun getAllCharacters(offset: Int, limit: Int): List<MarvelCharacterDto> {
        return characterNetworkApi.getAllCharacters(offset, limit).data?.results ?: emptyList()
    }

    override suspend fun getCharacterById(id: Int): MarvelCharacterDto? {
        return characterNetworkApi.getCharacterById(id).data?.results
    }

    override suspend fun getCharacterComics(id: Int, offset: Int, limit: Int): List<CharacterComicDto> {
        return characterNetworkApi.getCharacterComics(id, offset, limit).data?.results ?: emptyList()
    }

    override suspend fun getCharacterEvents(id: Int, offset: Int, limit: Int): List<CharacterEventDto> {
        return characterNetworkApi.getCharacterEvents(id, offset, limit).data?.results ?: emptyList()
    }

    override suspend fun getCharacterSeries(id: Int, offset: Int, limit: Int): List<CharacterSeriesDto> {
        return characterNetworkApi.getCharacterSeries(id, offset, limit).data?.results ?: emptyList()
    }

    override suspend fun getCharacterStories(id: Int, offset: Int, limit: Int): List<CharacterStoryDto> {
        return characterNetworkApi.getCharacterStories(id, offset, limit).data?.results ?: emptyList()
    }
}