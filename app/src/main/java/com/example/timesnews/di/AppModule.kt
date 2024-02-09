package com.example.timesnews.di

import android.app.Application
import com.example.timesnews.data.manager.LocalUserManagerImpl
import com.example.timesnews.data.remote.NewsApi
import com.example.timesnews.domain.manager.LocalUserManager
import com.example.timesnews.domain.repository.NewsRepository
import com.example.timesnews.domain.repository.NewsRepositoryImpl
import com.example.timesnews.domain.usecases.app_entry.AppEntryUseCases
import com.example.timesnews.domain.usecases.app_entry.ReadAppEntry
import com.example.timesnews.domain.usecases.app_entry.SaveAppEntry
import com.example.timesnews.domain.usecases.news.GetNews
import com.example.timesnews.domain.usecases.news.NewsUseCases
import com.example.timesnews.domain.usecases.news.SearchNews
import com.example.timesnews.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideLocalUserManager(
        application: Application
    ): LocalUserManager = LocalUserManagerImpl(application)

    @Provides
    @Singleton
    fun providesAppEntryUseCases(
        localUserManager: LocalUserManager
    ) = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )

    @Provides
    @Singleton
    fun provideNewsApi(): NewsApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi
    ): NewsRepository = NewsRepositoryImpl(newsApi)

    @Provides
    @Singleton
    fun provideNewsUseCase(
        newsRepository: NewsRepository
    ): NewsUseCases {
        return NewsUseCases(
            getNews = GetNews(newsRepository),
            searchNews = SearchNews(newsRepository)
        )
    }
}