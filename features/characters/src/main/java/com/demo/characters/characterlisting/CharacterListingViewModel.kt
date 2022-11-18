package com.demo.characters.characterlisting

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.lifecycle.viewModelScope
import androidx.navigation.*
import com.demo.domain.usecases.DeleteAllMarvelCharactersInDBUseCase
import com.demo.domain.usecases.GetAllMarvelCharactersUseCase
import com.demo.model.MarvelCharacter
import com.demo.navigation.NavigationManager
import com.demo.navigation.directions.CharacterDirections
import com.demo.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterListingViewModel @Inject constructor(
    private val getAllMarvelCharactersUseCase: GetAllMarvelCharactersUseCase,
    private val deleteAllMarvelCharactersInDBUseCase: DeleteAllMarvelCharactersInDBUseCase,
    private val navigationManager: NavigationManager
) : BaseViewModel() {

    private val _uiState = MutableStateFlow(CharacterListingUiState(mutableListOf()))
    val uiState: StateFlow<CharacterListingUiState> = _uiState

    private val _isRefreshing = MutableStateFlow(false)
    val isRefreshing = _isRefreshing.asStateFlow()

    private var _offset : Int = 0

    init {
        getMarvelCharacters()
    }

    fun refresh() = viewModelScope.launch {
        _isRefreshing.value = true
        _uiState.value = CharacterListingUiState(mutableListOf())
        deleteAllMarvelCharactersInDBUseCase.invoke()
        getMarvelCharacters()
        _isRefreshing.value = false
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

    fun navigateToCharacterDetails(characterId : Int){
        val characterDirections = CharacterDirections.characterDetails
        characterDirections.arguments = arrayListOf(
            navArgument("characterId"){
                type = NavType.IntType
                defaultValue = characterId
            }
        )
        navigationManager.navigate(characterDirections)
    }
}