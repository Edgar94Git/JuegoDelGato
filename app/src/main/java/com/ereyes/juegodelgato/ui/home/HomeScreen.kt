package com.ereyes.juegodelgato.ui.home

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Switch
import androidx.compose.material.SwitchColors
import androidx.compose.material.SwitchDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ereyes.juegodelgato.R
import com.ereyes.juegodelgato.ui.theme.Accent
import com.ereyes.juegodelgato.ui.theme.Background
import com.ereyes.juegodelgato.ui.theme.Orange1
import com.ereyes.juegodelgato.ui.theme.Orange2

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
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Header()
        Body(
            onCreateGame = {  viewModel.onCreateGame(navigateToGame) },
            onJoinGame = { id -> viewModel.onJoinGame(id, navigateToGame) }
        )
    }
}

@Composable
fun Body(onCreateGame: () -> Unit, onJoinGame: (String) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(24.dp),
        backgroundColor = Background,
        border = BorderStroke(2.dp, Orange1),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            var createGame by remember{ mutableStateOf(true) }
            Switch(
                checked = createGame,
                onCheckedChange = { createGame = it },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Orange2,
                )
            )
            AnimatedContent(targetState = createGame, label= "") {
                when(it){
                    true -> CreateGame(onCreateGame)
                    false -> JoinGame(onJoinGame)
                }
            }
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
fun CreateGame(onCreateGame: () -> Unit){
    Button(
        onClick = { onCreateGame() },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Orange2
        )
    ) {
        Text(
            text = "Crear partida",
            color = Accent
        )
    }
}

@Composable
fun JoinGame(onJoinGame:(String) -> Unit){
    var text by remember { mutableStateOf("") }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = Accent,
                focusedBorderColor = Orange2,
                unfocusedBorderColor = Accent
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = { onJoinGame(text) },
            enabled = text.isNotEmpty(),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Orange2
            )
        ) {
            Text(
                text = "Unirse a la Partida",
                color = Accent
            )
        }
    }
}

@Composable
fun Header(){
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(24.dp))
        Box(
            modifier = Modifier
                .size(200.dp)
                .padding(12.dp)
                .clip(RoundedCornerShape(24.dp))
                .border(2.dp, Orange1, RoundedCornerShape(24.dp)),
            contentAlignment = Alignment.Center
        ){
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                painter = painterResource(id = R.drawable.applogo),
                contentDescription = "Logo"
            )
        }
        Text(
            text = "Juego del gato",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Orange1
        )
    }
}