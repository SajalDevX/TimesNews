package com.example.timesnews.presentation.bookmark

import com.example.timesnews.domain.model.Article

data class BookmarkState(
    val articles: List<Article> = emptyList()
)