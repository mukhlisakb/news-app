package com.mukhlisakb.newsapps.di

import com.mukhlisakb.newsapps.AppViewModelFactory
import com.mukhlisakb.newsapps.data.repositories.NewRepositoryImpl
import com.mukhlisakb.newsapps.data.source.api.NewsService
import com.mukhlisakb.newsapps.data.source.api.RetrofitClient
import com.mukhlisakb.newsapps.domain.repository.NewsRepository
import com.mukhlisakb.newsapps.domain.usecase.GetTopHeadlinesUseCase
import com.mukhlisakb.newsapps.presentation.list.NewsViewModel

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

    fun provideViewModelFactory(): AppViewModelFactory {
        return AppViewModelFactory().apply {
            registerCreator(NewsViewModel::class.java) {
                NewsViewModel(getTopHeadlinesuseCase)
            }
        }
    }
}