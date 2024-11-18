package com.mukhlisakb.newsapps.data.source.api

import com.mukhlisakb.newsapps.data.dto.NewsResponseDTO
import okhttp3.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {
    @GET("/v2/top-headlines")
    suspend fun getTopHeadlines(
        @Query("q") category: String = "business",
        @Query("apiKey") apiKey: String
    ): NewsResponseDTO
}