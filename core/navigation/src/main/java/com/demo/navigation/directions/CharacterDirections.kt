package com.demo.navigation.directions

import androidx.navigation.NamedNavArgument
import com.demo.navigation.NavigationCommand

object CharacterDirections {

    val root = object : NavigationCommand {

        override var arguments = mutableListOf<NamedNavArgument>()

        override var destination: String = "characterListing"

        override fun getFullDestination(): String{
            return destination
        }
    }

    val characterDetails = object : NavigationCommand {

        override var arguments = mutableListOf<NamedNavArgument>()

        override var destination: String = "characterDetails"

        override fun getFullDestination(): String{
            return "$destination${appendArguments()}"
        }

    }
}