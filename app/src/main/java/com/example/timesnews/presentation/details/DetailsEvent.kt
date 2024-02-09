package com.example.timesnews.presentation.details

import com.example.timesnews.domain.model.Article

sealed class DetailsEvent {

    data class UpsertDeleteArticle(val article : Article) : DetailsEvent()
    object RemoveSideEffect :DetailsEvent()

}