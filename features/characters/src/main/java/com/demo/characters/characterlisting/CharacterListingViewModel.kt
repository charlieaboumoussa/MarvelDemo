package com.demo.characters.characterlisting

import com.demo.model.MarvelCharacter
import com.demo.ui.base.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CharacterListingViewModel : BaseViewModel() {

    private val _uiState = MutableStateFlow<CharacterListingUiState>(CharacterListingUiState(
        characters = mutableListOf(
            MarvelCharacter(
                1,
                "Batman",
                "",
                "",
                "",
                "",
                ""),
            MarvelCharacter(
                2,
                "Spider Man",
                "",
                "",
                "",
                "",
                ""),
            MarvelCharacter(
                3,
                "X-Man",
                "",
                "",
                "",
                "",
                ""),
        )
    ))
    val uiState: StateFlow<CharacterListingUiState> = _uiState
}