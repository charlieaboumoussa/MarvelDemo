package com.demo.characters.characterlisting

import com.demo.model.MarvelCharacter

data class CharacterListingUiState(
    val characters: MutableList<MarvelCharacter>? = null,
    val offset : Int = 0,
    val limit : Int = 20
)
