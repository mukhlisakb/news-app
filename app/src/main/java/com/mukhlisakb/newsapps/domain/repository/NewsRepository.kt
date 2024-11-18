package com.mukhlisakb.newsapps.domain.repository

import com.mukhlisakb.newsapps.domain.entities.NewsResponse

interface NewsRepository {
    suspend fun getTpHeadlines(category: String, apiKey: String): NewsResponse

}