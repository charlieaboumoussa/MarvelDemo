package com.demo.domain.usecases

import com.demo.common.state.Resource
import com.demo.data.repository.character.CharacterRepository
import com.demo.model.MarvelCharacter
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetMarvelCharacterByIdUseCase @Inject constructor(
    private val charactersRepository: CharacterRepository
) {

    operator fun invoke(id: Int): Flow<Resource<MarvelCharacter>> = flow {
        emit(Resource.Loading())
        try {
            charactersRepository.getCharacterById(id).collect {
                emit(Resource.Success(it))
            }
        } catch (exception: Exception) {
            emit(Resource.Error(exception.message ?: ""))
        }
    }
}