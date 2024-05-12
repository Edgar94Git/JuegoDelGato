package com.ereyes.juegodelgato.ui.core

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ereyes.juegodelgato.ui.core.Routes.*
import com.ereyes.juegodelgato.ui.game.GameScreen
import com.ereyes.juegodelgato.ui.home.HomeScreen

/****
 * Project: JuegoDelGato
 * From: com.ereyes.juegodelgato.ui.core
 * Created by Edgar Reyes Gonzalez on 5/11/2024 at 11:11 AM
 * All rights reserved 2024.
 ****/
@Composable
fun ContentWrapper(navigationController: NavHostController) {
    NavHost(
        navController = navigationController,
        startDestination = Home.route
    ) {
        composable(Home.route) {
            HomeScreen(
                navigateToGame = {
                    navigationController.navigate(Game.route)
                }
            )
        }
        composable(Game.route) {
            GameScreen()
        }
    }
}

sealed class Routes(val route: String) {
    data object Home : Routes("home")
    data object Game : Routes("game")
}