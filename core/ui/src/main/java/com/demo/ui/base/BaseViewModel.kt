package com.demo.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.common.state.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

open class BaseViewModel : ViewModel() {
    enum class RemoteExceptions(val value :String){
        DEFAULT("0")
    }

    private val _uiBaseState = MutableStateFlow<Resource<Boolean>?>(null)
    val uiBaseState: StateFlow<Resource<Boolean>?> = _uiBaseState


    fun showLoading(){
        viewModelScope.launch {
            _uiBaseState.emit(Resource.Loading(true))
        }
    }

    fun hideLoading(){
        viewModelScope.launch {
            _uiBaseState.emit(Resource.Loading(false))
        }
    }

    fun showError(errorMessage : String){
        viewModelScope.launch {
            _uiBaseState.emit(Resource.Error(errorMessage, true))
        }
    }

    fun showError(exception : RemoteExceptions){
        viewModelScope.launch {
            when(exception){
                RemoteExceptions.DEFAULT->{
                    _uiBaseState.emit(Resource.Error(exception.value, true))
                }
            }
        }
    }
}