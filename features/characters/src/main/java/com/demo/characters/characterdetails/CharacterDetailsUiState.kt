package com.demo.characters.characterlisting

import com.demo.model.*
import com.demo.ui.base.BaseState

data class CharacterDetailsUiState(
    val character: MarvelCharacter? = null,
    val characterComics: List<CharacterComic>? = null,
    val characterStories: List<CharacterStory>? = null,
    val characterSeries: List<CharacterSeries>? = null,
    val characterEvents: List<CharacterEvent>? = null,
): BaseState()
