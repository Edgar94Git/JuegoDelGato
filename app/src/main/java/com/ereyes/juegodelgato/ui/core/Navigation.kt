package com.ereyes.juegodelgato.ui.core

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
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
                navigateToGame = { gameId, userId, owner ->
                    navigationController.navigate(Game.createRoute(gameId, userId, owner))
                }
            )
        }
        composable(Game.route,
            arguments = listOf(
                navArgument("gameId") { type = NavType.StringType },
                navArgument("userId") { type = NavType.StringType },
                navArgument("owner") { type = NavType.BoolType }
            )
        ) {
            GameScreen(
                gameId = it.arguments?.getString("gameId").orEmpty(),
                userId = it.arguments?.getString("userId").orEmpty(),
                owner = it.arguments?.getBoolean("owner") ?: false,
                navigationToHome = {
                    navigationController.popBackStack()
                }
            )
        }
    }
}

sealed class Routes(val route: String) {
    object Home : Routes("home")
    object Game : Routes("game/{gameId}/{userId}/{owner}"){
        fun createRoute(gameId: String, userId: String, owner:Boolean): String {
            return "game/$gameId/$userId/$owner"
        }
    }
}