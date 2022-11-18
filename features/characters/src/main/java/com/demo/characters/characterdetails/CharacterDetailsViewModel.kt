package com.demo.characters.characterlisting

import androidx.lifecycle.viewModelScope
import com.demo.domain.usecases.*
import com.demo.model.MarvelCharacter
import com.demo.navigation.NavigationManager
import com.demo.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterDetailsViewModel @Inject constructor(
    private val getMarvelCharacterByIdUseCase: GetMarvelCharacterByIdUseCase,
    private val getAllCharacterEventsByIdUseCase: GetAllCharacterEventsByIdUseCase,
    private val getAllCharacterSeriesByIdUseCase: GetAllCharacterSeriesByIdUseCase,
    private val getAllCharacterStoriesByIdUseCase: GetAllCharacterStoriesByIdUseCase,
    private val getAllCharacterComicsByIdUseCase: GetAllCharacterComicsByIdUseCase,
    private val navigationManager: NavigationManager
) : BaseViewModel() {

    private val _uiState = MutableStateFlow(CharacterDetailsUiState())
    val uiState: StateFlow<CharacterDetailsUiState> = _uiState

    private var _characterId : Int?= null
    private val _offset = 0
    private val _limit = 3

    fun setCharacterId(characterId: Int){
        _characterId = characterId
    }

    fun getCharacterByIdFromDB(characterId: Int){
        viewModelScope.launch(Dispatchers.IO) {
            getMarvelCharacterByIdUseCase
                .invoke(characterId)
                .collect {
                    when{
                        it.isLoading()->{}
                        it.isSuccess()->{
                            it.data?.let {
                                _uiState.value = CharacterDetailsUiState(
                                    character = it
                                )
                            }
                        }
                        it.isError()->{}
                    }
                }
        }

    }

    fun getCharacterComics() {
        viewModelScope.launch {
            _uiState.value.character?.let {
                getAllCharacterComicsByIdUseCase.invoke(it.id, _offset, _limit)
                    .collect {
                        when{
                            it.isLoading()->{}
                            it.isSuccess()->{
                                it.data?.let {
                                    _uiState.value = _uiState.value.copy(
                                        characterComics = it
                                    )
                                }
                            }
                            it.isError()->{}
                        }
                    }
            }
        }
    }

    fun getCharacterEvents() {
        viewModelScope.launch {
            _uiState.value.character?.let {
                getAllCharacterEventsByIdUseCase.invoke(it.id, _offset, _limit)
                    .collect {
                        when{
                            it.isLoading()->{}
                            it.isSuccess()->{
                                it.data?.let {
                                    _uiState.value = _uiState.value.copy(
                                        characterEvents = it
                                    )
                                }
                            }
                            it.isError()->{}
                        }
                    }
            }
        }
    }

    fun getCharacterStories() {
        viewModelScope.launch {
            _uiState.value.character?.let {
                getAllCharacterStoriesByIdUseCase.invoke(it.id, _offset, _limit)
                    .collect {
                        when{
                            it.isLoading()->{}
                            it.isSuccess()->{
                                it.data?.let {
                                    _uiState.value = _uiState.value.copy(
                                        characterStories = it
                                    )
                                }
                            }
                            it.isError()->{}
                        }
                    }
            }
        }
    }

    fun getCharacterSeries() {
        viewModelScope.launch {
            _uiState.value.character?.let {
                getAllCharacterSeriesByIdUseCase.invoke(it.id, _offset, _limit)
                    .collect {
                        when{
                            it.isLoading()->{}
                            it.isSuccess()->{
                                it.data?.let {
                                    _uiState.value = _uiState.value.copy(
                                        characterSeries = it
                                    )
                                }
                            }
                            it.isError()->{}
                        }
                    }
            }
        }
    }

    fun popNavigation(){
        navigationManager.popBackStack()
    }
}