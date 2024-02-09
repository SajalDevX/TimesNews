package com.example.timesnews.data.remote.dto

import com.example.timesnews.domain.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)