package com.demo.marveldemo.ui.landing

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.findNavController
import com.demo.characters.characterlisting.CharacterListingScreen
import com.demo.marveldemo.ui.NavRoutes
import com.demo.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LandingActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavHost(
                navController = rememberNavController(),
                startDestination = NavRoutes.CHARACTER_LISTING
            ) {
                composable(NavRoutes.CHARACTER_LISTING) {
                    CharacterListingScreen()
                }
                composable(NavRoutes.CHARACTER_DETAILS) {
                    CharacterListingScreen()
                }
            }

        }

    }

}