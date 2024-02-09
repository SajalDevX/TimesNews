package com.example.timesnews.domain.usecases.news

import com.example.timesnews.data.local.NewsDao
import com.example.timesnews.domain.model.Article
import com.example.timesnews.domain.repository.NewsRepository

class DeleteArticle(
    private val newsRepository: NewsRepository
){
    suspend operator fun invoke(article: Article){
        newsRepository.deleteArticle(article)
    }
}