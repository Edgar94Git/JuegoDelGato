package com.ereyes.juegodelgato.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

/****
 * Project: JuegoDelGato
 * From: com.ereyes.juegodelgato.ui.home
 * Created by Edgar Reyes Gonzalez on 5/10/2024 at 4:55 PM
 * All rights reserved 2024.
 ****/

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    navigateToGame: (String, String, Boolean) -> Unit
){
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.weight(1f))
        CreateGame(
            onCreateGame = {
                viewModel.onCreateGame(navigateToGame)
            }
        )
        Spacer(modifier = Modifier.weight(1f))
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(2.dp)
        )
        Spacer(modifier = Modifier.weight(1f))
        JoinGame(
            onJoinGame = { id ->
                viewModel.onJoinGame(id, navigateToGame)
            }
        )
        Spacer(modifier = Modifier.weight(1f))
    }
}

@Composable
fun CreateGame(onCreateGame: () -> Unit){
    Button(onClick = { onCreateGame() }) {
        Text(text = "Create game")
    }
}

@Composable
fun JoinGame(onJoinGame:(String) -> Unit){
    var text by remember { mutableStateOf("") }
    TextField(value = text, onValueChange = { text = it })
    Button(
        onClick = { onJoinGame(text) },
        enabled = text.isNotEmpty()
    ) {
        Text(text = "Join to game")
    }
}