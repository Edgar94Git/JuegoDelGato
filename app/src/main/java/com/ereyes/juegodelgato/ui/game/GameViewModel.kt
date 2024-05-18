package com.ereyes.juegodelgato.ui.game

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ereyes.juegodelgato.data.network.FirebaseService
import com.ereyes.juegodelgato.ui.model.GameModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/****
 * Project: JuegoDelGato
 * From: com.ereyes.juegodelgato.ui.game
 * Created by Edgar Reyes Gonzalez on 5/11/2024 at 11:06 AM
 * All rights reserved 2024.
 ****/

@HiltViewModel
class GameViewModel @Inject constructor(
    private val firebaseService: FirebaseService
): ViewModel() {
    
    private lateinit var gameId: String

    private val _game = MutableStateFlow<GameModel?>(null)
    val game: StateFlow<GameModel?> = _game
    
    fun joinToGame(gameId: String, userId: String, owner: Boolean) {
        this.gameId = gameId
        if(owner){
            joinToGameLikeOwner(gameId)
        }else{
            joinToGameLikeGuest(gameId)
        }
    }

    private fun joinToGameLikeGuest(gameId: String) {

    }

    private fun joinToGameLikeOwner(gameId: String) {
        viewModelScope.launch {
            firebaseService.joinToGame(gameId).collect {
                _game.value = it
            }
        }
    }
}