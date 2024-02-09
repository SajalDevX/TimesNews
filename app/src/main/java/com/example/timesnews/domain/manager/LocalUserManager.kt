package com.example.timesnews.domain.manager

import kotlinx.coroutines.flow.Flow

interface LocalUserManager{
    suspend fun saveAppEntry()

    //Made some suspend function changes here
    fun readAppEntry(): Flow<Boolean>
}