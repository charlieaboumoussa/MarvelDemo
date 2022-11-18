package com.demo.navigation

import androidx.navigation.NamedNavArgument

interface NavigationCommand : BaseNavCommand {

    var arguments: MutableList<NamedNavArgument>

    var destination: String

    fun getFullDestination(): String

    fun appendArguments(): String{
        var suffix = ""
        if(arguments.isNotEmpty()){
            arguments.forEach{
                suffix = suffix.plus("/${it.argument.defaultValue}")
            }
        }
        return suffix
    }
}