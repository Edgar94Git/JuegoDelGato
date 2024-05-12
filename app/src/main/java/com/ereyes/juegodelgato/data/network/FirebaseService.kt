package com.ereyes.juegodelgato.data.network

import com.ereyes.juegodelgato.data.model.GameData
import com.google.firebase.database.DatabaseReference
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

    fun createGame(gameData: GameData){
        val gameReference = reference.child(PATH).push()
        gameReference.setValue(gameData)
    }

}