package com.ereyes.juegodelgato.di

import com.ereyes.juegodelgato.data.network.FirebaseService
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/****
 * Project: JuegoDelGato
 * From: com.ereyes.juegodelgato.di
 * Created by Edgar Reyes Gonzalez on 5/11/2024 at 12:06 PM
 * All rights reserved 2024.
 ****/

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideDatabaseReference(): DatabaseReference {
        return Firebase.database.reference
    }

    @Provides
    @Singleton
    fun provideFirebaseService(reference: DatabaseReference): FirebaseService {
        return FirebaseService(reference)
    }

}