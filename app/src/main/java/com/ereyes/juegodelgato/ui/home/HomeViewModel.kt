package com.ereyes.juegodelgato.ui.home

import androidx.lifecycle.ViewModel
import com.ereyes.juegodelgato.data.model.GameData
import com.ereyes.juegodelgato.data.model.PlayerData
import com.ereyes.juegodelgato.data.network.FirebaseService
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/****
 * Project: JuegoDelGato
 * From: com.ereyes.juegodelgato.ui.home
 * Created by Edgar Reyes Gonzalez on 5/10/2024 at 5:30 PM
 * All rights reserved 2024.
 ****/

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val firebaseService: FirebaseService
): ViewModel() {

    fun onCreateGame() {
        firebaseService.createGame(createNewGame())
    }

    private fun createNewGame(): GameData{
        val currentPlayer = PlayerData(playerType = 1)
        return GameData(
            board = List(9) { 0 },
            player1 = currentPlayer,
            playerTurn = currentPlayer,
            player2 = null
        )
    }

    fun onJoinGame(id: String) {

    }

}