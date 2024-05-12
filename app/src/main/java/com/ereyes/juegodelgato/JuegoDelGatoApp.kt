package com.ereyes.juegodelgato

import android.app.Application
import com.google.firebase.FirebaseApp
import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.initialize
import dagger.hilt.android.HiltAndroidApp

/****
 * Project: JuegoDelGato
 * From: com.ereyes.juegodelgato
 * Created by Edgar Reyes Gonzalez on 5/10/2024 at 4:25 PM
 * All rights reserved 2024.
 ****/

@HiltAndroidApp
class JuegoDelGatoApp: Application() {

    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
    }
}