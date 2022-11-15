package com.demo.domain.repositories

import com.demo.domain.entities.MarvelCharacter

interface CharactersRepository {
    suspend fun getAllCharacters() : ArrayList<MarvelCharacter>
}