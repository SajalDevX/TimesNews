package com.example.timesnews.domain.usecases.app_entry

import com.example.timesnews.domain.usecases.app_entry.ReadAppEntry
import com.example.timesnews.domain.usecases.app_entry.SaveAppEntry

data class AppEntryUseCases(
    val readAppEntry: ReadAppEntry,
    val saveAppEntry: SaveAppEntry
)
