package com.demo.characters.characterlisting

import com.demo.model.MarvelCharacter
import com.demo.ui.base.BaseState

data class CharacterListingUiState(
    val characters: MutableList<MarvelCharacter>? = null,
    val offset : Int = 0,
    val limit : Int = 20
): BaseState()
