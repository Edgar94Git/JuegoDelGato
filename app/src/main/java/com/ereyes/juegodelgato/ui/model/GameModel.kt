package com.ereyes.juegodelgato.ui.model

/****
 * Project: JuegoDelGato
 * From: com.ereyes.juegodelgato.ui.model
 * Created by Edgar Reyes Gonzalez on 5/17/2024 at 8:13 PM
 * All rights reserved 2024.
 ****/
data class GameModel(
    val board: List<PlayerType>,
    val player1: PlayerModel,
    val player2: PlayerModel? = null,
    val playerTurn: PlayerModel,
    val gameId: String
)

data class PlayerModel(val userId: String, val playerType: PlayerType)

sealed class PlayerType(val id: Int, val symbol: String){
    object FirstPlayer: PlayerType(2, "X")
    object SecondPlayer: PlayerType(3, "O")
    object Empty: PlayerType(0, "")

    companion object{
        fun getPlayerById(id: Int?): PlayerType{
            return when(id){
                FirstPlayer.id -> FirstPlayer
                SecondPlayer.id -> SecondPlayer
                else -> Empty
            }
        }
    }
}