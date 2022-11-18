package com.demo.characters.characterlisting

import androidx.lifecycle.viewModelScope
import com.demo.domain.usecases.GetAllMarvelCharactersUseCase
import com.demo.model.MarvelCharacter
import com.demo.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterDetailsViewModel @Inject constructor(
    private val getAllMarvelCharactersUseCase: GetAllMarvelCharactersUseCase
) : BaseViewModel() {

    private val _uiState = MutableStateFlow(CharacterDetailsUiState())
    val uiState: StateFlow<CharacterDetailsUiState> = _uiState

    fun setMarvelCharacter(character: MarvelCharacter){
        _uiState.value = CharacterDetailsUiState(
            character = character
        )
    }

    fun getCharacterComics() {
        viewModelScope.launch {
//            getAllMarvelCharactersUseCase.invoke()
//                .collect {
//                    if(it.isSuccess()){
//                        it.data?.let {
//
//                        }
//                    }
//                }
        }
    }
}