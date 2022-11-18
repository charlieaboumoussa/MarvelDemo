package com.demo.ui.base

open class BaseState(
    var state: State = State.DEFAULT
)

enum class State{
    DEFAULT,
    SUCCESS,
    LOADING,
    ERROR,
}