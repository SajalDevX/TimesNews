package com.example.timesnews.presentation.search

import androidx.paging.PagingData
import com.example.timesnews.domain.model.Article
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Query

data class SearchState(
    val searchQuery: String = "",
    val articles: Flow<PagingData<Article>>? = null
)