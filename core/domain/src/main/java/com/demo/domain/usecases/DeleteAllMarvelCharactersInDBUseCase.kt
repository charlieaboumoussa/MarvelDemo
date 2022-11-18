package com.demo.domain.usecases

import com.demo.common.state.Resource
import com.demo.data.repository.character.CharacterRepository
import com.demo.model.MarvelCharacter
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DeleteAllMarvelCharactersInDBUseCase @Inject constructor(
    private val charactersRepository: CharacterRepository
) {

    operator fun invoke(): Flow<Resource<Any>> = flow {
        emit(Resource.Loading())
        try {
            charactersRepository.deleteAllCharacters()
        } catch (exception: Exception) {
            emit(Resource.Error(exception.message ?: ""))
        }
    }
}