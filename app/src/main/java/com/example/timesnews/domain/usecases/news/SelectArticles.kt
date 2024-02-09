package com.example.timesnews.domain.usecases.news

import com.example.timesnews.data.local.NewsDao
import com.example.timesnews.domain.model.Article
import com.example.timesnews.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class SelectArticles(
    private val newsRepository: NewsRepository
){
     operator fun invoke(): Flow<List<Article>> {
        return newsRepository.selectArticles()
    }
}