package com.mukhlisakb.newsapps.DI

import com.mukhlisakb.newsapps.AppViewModelFactory
import com.mukhlisakb.newsapps.data.repositories.NewRepositoryImpl
import com.mukhlisakb.newsapps.data.source.api.NewsService
import com.mukhlisakb.newsapps.data.source.api.RetrofitClient
import com.mukhlisakb.newsapps.domain.repository.NewsRepository
import com.mukhlisakb.newsapps.domain.usecase.GetTopHeadlinesUseCase

class AppContainer {
    private val retrofit = RetrofitClient.retrofit
    private val newsService: NewsService by lazy {
        retrofit.create(NewsService::class.java)
    }
    val newsRepository: NewsRepository by lazy {
        NewRepositoryImpl(newsService)
    }
    val getTopHeadlinesuseCase: GetTopHeadlinesUseCase by lazy {
        GetTopHeadlinesUseCase(newsRepository)
    }

    val provideViewModelFactory(): AppViewModelFactory {
        return AppViewModelFactory.apply {
            // Rgeister viewmodel
        }
    }
}