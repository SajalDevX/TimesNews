package com.example.timesnews.domain.usecases.news

import androidx.paging.PagingData
import com.example.timesnews.domain.model.Article
import com.example.timesnews.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetNews(
    private val newsRepository: NewsRepository
) {
    operator fun invoke(sources: List<String>): Flow<PagingData<Article>> {
        return newsRepository.getNews(sources = sources)
    }
}