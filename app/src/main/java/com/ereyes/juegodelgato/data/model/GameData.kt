package com.ereyes.juegodelgato.data.model

import com.ereyes.juegodelgato.ui.model.GameModel
import com.ereyes.juegodelgato.ui.model.PlayerModel
import com.ereyes.juegodelgato.ui.model.PlayerType
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
) {
    fun toModel(): GameModel {
        return GameModel(
            board = board?.map {PlayerType.getPlayerById(it) } ?: mutableListOf(),
            gameId = gameId.orEmpty(),
            player1 = player1!!.toModel(),
            player2 = player2?.toModel(),
            playerTurn = playerTurn!!.toModel()
        )
    }
}

data class PlayerData(
    val userId: String? = Calendar.getInstance().timeInMillis.hashCode().toString(),
    val playerType: Int? = null
){
    fun toModel(): PlayerModel {
        return PlayerModel(
            userId!!,
            PlayerType.getPlayerById(playerType)
        )
    }
}
