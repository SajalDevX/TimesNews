package com.example.timesnews.domain.usecases.app_entry

import com.example.timesnews.domain.manager.LocalUserManager

class SaveAppEntry(
    private val localUserManager:LocalUserManager
){
    suspend operator fun invoke(){
        localUserManager.saveAppEntry()
    }
}