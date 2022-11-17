package com.demo.characters.characterlisting

import androidx.lifecycle.viewModelScope
import com.demo.domain.usecases.GetAllMarvelCharactersUseCase
import com.demo.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterListingViewModel @Inject constructor(
    private val getAllMarvelCharactersUseCase: GetAllMarvelCharactersUseCase
) : BaseViewModel() {

    private val _uiState = MutableStateFlow(CharacterListingUiState(mutableListOf()))
    val uiState: StateFlow<CharacterListingUiState> = _uiState

    private var _offset : Int = 0

    init {
        getMarvelCharacters()
    }

    fun getMarvelCharacters() {
        viewModelScope.launch {
            getAllMarvelCharactersUseCase.invoke(_uiState.value.offset, _uiState.value.limit)
                .collect {
                    when{
                        it.isSuccess()->{
                            hideLoading()
                            it.data?.let {
                                _offset++
                                _uiState.value = CharacterListingUiState(
                                    characters = it.toMutableList(),
                                    _offset
                                )
                            }
                        }
                        it.isLoading()->{
                            showLoading()
                        }
                        it.isError()->{
                            hideLoading()
                            showError(it.message?:"")
                        }
                    }
                }
        }
    }
}