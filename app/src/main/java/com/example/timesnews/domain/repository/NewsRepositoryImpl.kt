package com.example.timesnews.domain.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.timesnews.data.remote.NewsApi
import com.example.timesnews.data.remote.NewsPagingSource
import com.example.timesnews.data.remote.SearchNewsPagingSorce
import com.example.timesnews.data.remote.dto.NewsResponse
import com.example.timesnews.domain.model.Article
import kotlinx.coroutines.flow.Flow

class NewsRepositoryImpl(
    private val newsApi: NewsApi
) : NewsRepository {
    override fun getNews(sources: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                NewsPagingSource(
                    newsApi = newsApi,
                    sources = sources.joinToString(separator = ",")
                )

            }
        ).flow
    }

    override fun searchNews(searchQuery: String, sources: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                SearchNewsPagingSorce(
                    searchQuery=searchQuery,
                    newsApi = newsApi,
                    sources = sources.joinToString(separator = ",")
                )

            }
        ).flow
    }
}