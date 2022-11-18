package com.demo.navigation

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

class NavigationManager {

    var _commands = MutableSharedFlow<BaseNavCommand?>()
    val commands: SharedFlow<BaseNavCommand?> = _commands

    fun navigate(
        directions: BaseNavCommand
    ) {
        CoroutineScope(Dispatchers.Main).launch{
            _commands.emit(directions)
        }
    }

    fun popBackStack(){
        CoroutineScope(Dispatchers.Main).launch{
            _commands.emit(PopBackStackCommand())
        }
    }

}