package com.ereyes.juegodelgato.data.network

import com.ereyes.juegodelgato.data.model.GameData
import com.ereyes.juegodelgato.ui.model.GameModel
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.snapshots
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/****
 * Project: JuegoDelGato
 * From: com.ereyes.juegodelgato.data.network
 * Created by Edgar Reyes Gonzalez on 5/11/2024 at 11:50 AM
 * All rights reserved 2024.
 ****/
class FirebaseService @Inject constructor(private val reference: DatabaseReference) {

    companion object{
        private const val PATH = "games"
    }

    fun createGame(gameData: GameData): String{
        val gameReference = reference.child(PATH).push()
        val key = gameReference.key
        val newGame = gameData.copy(gameId = key)
        gameReference.setValue(newGame)
        return newGame.gameId.orEmpty()
    }

    fun joinToGame(gameId: String): Flow<GameModel?> {
        return reference.database.reference.child("$PATH/$gameId").snapshots.map { dataSnapshot ->
            dataSnapshot.getValue(GameData::class.java)?.toModel()
        }
    }

    fun updateGame(gameData: GameData) {
        if(gameData.gameId != null){
            reference.child(PATH).child(gameData.gameId).setValue(gameData)
        }
    }

}