package com.demo.domain1.usecases

import com.demo.common.state.Resource
import com.demo.data.repository.character.CharacterRepository
import com.demo.model.MarvelCharacter
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetAllMarvelCharactersUseCase @Inject constructor(
    private val charactersRepository: CharacterRepository
) {

    operator fun invoke(offset: Int, limit: Int): Flow<Resource<List<MarvelCharacter>>> = flow {
        emit(Resource.Loading())
        try {
            charactersRepository.getAllCharacters(offset, limit).collect {
                emit(Resource.Success(it))
            }
        } catch (exception: Exception) {
            emit(Resource.Error(exception.message ?: ""))
        }
    }
}