package com.demo.marveldemo

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.demo.characters.characterlisting.CharacterDetailsScreen
import com.demo.characters.characterlisting.CharacterListingScreen
import com.demo.marveldemo.theme.AppTheme
import com.demo.navigation.NavigationCommand
import com.demo.navigation.NavigationManager
import com.demo.navigation.PopBackStackCommand
import com.demo.navigation.directions.CharacterDirections
import com.demo.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    @Inject
    lateinit var navigationManager: NavigationManager

    lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            navController = rememberNavController()
            AppTheme() {
                NavHost(
                    navController = navController,
                    startDestination = CharacterDirections.root.destination
                ) {
                    composable(CharacterDirections.root.destination) {
                        CharacterListingScreen()
                    }
                    composable(
                        route = "${CharacterDirections.characterDetails.destination}/{characterId}",
                        arguments = listOf(
                            navArgument("characterId") {
                                type = NavType.IntType
                            }
                        )
                    ) {backStackEntry->
                        val characterId = backStackEntry.arguments?.getInt("characterId") ?: 0
                        CharacterDetailsScreen(characterId = characterId)
                    }
                }
            }
        }
        lifecycleScope.launch {
            navigationManager.commands.collect{ command ->
                command?.let {
                    when(it){
                        is PopBackStackCommand->{
                            navController.popBackStack()
                        }
                        else->{
                            val destination = (it as NavigationCommand).getFullDestination()
                            if (destination.isNotEmpty()) {
                                navController.navigate(destination)
                            }
                        }
                    }
                }
            }
        }
    }

}