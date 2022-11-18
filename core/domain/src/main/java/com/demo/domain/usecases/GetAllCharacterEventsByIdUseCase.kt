package com.demo.domain.usecases

import com.demo.common.state.Resource
import com.demo.data.repository.character.CharacterRepository
import com.demo.model.CharacterComic
import com.demo.model.CharacterEvent
import com.demo.model.MarvelCharacter
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetAllCharacterEventsByIdUseCase @Inject constructor(
    private val charactersRepository: CharacterRepository
) {

    operator fun invoke(id: Int, offset: Int, limit: Int): Flow<Resource<List<CharacterEvent>>> = flow {
        emit(Resource.Loading())
        try {
            charactersRepository.getCharacterEvents(id, offset, limit).collect {
                emit(Resource.Success(it))
            }
        } catch (exception: Exception) {
            emit(Resource.Error(exception.message ?: ""))
        }
    }
}