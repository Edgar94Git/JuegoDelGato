package com.ereyes.juegodelgato.data.model

import java.util.Calendar

/****
 * Project: JuegoDelGato
 * From: com.ereyes.juegodelgato.data.model
 * Created by Edgar Reyes Gonzalez on 5/11/2024 at 12:00 PM
 * All rights reserved 2024.
 ****/
data class GameData(
    val board: List<Int?>? = null,
    val gameId: String? = null,
    val player1: PlayerData? = null,
    val player2: PlayerData? = null,
    val playerTurn: PlayerData? = null

)

data class PlayerData(
    val userId: String? = Calendar.getInstance().timeInMillis.hashCode().toString(),
    val playerType: Int? = null
)
