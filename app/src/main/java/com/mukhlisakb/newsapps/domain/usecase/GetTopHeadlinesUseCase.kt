package com.mukhlisakb.newsapps.domain.usecase

import com.mukhlisakb.newsapps.domain.entities.NewsResponse
import com.mukhlisakb.newsapps.domain.repository.NewsRepository

class GetTopHeadlinesUseCase(private val newRepository: NewsRepository){
    suspend operator fun invoke(category: String, apiKey: String): NewsResponse {
        return newRepository.getTpHeadlines(category, apiKey)
    }
}