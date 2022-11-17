package com.demo.characters.characterlisting

import com.demo.model.MarvelCharacter

data class CharacterListingUiState(
    val characters: MutableList<MarvelCharacter> = mutableListOf()
)
