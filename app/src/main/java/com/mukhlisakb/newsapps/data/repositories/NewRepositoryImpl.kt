package com.mukhlisakb.newsapps.data.repositories

import com.mukhlisakb.newsapps.data.dto.NewsResponseDTO
import com.mukhlisakb.newsapps.data.source.api.NewsService
import com.mukhlisakb.newsapps.domain.entities.Article
import com.mukhlisakb.newsapps.domain.entities.NewsResponse
import com.mukhlisakb.newsapps.domain.entities.Source
import com.mukhlisakb.newsapps.domain.repository.NewsRepository

class NewRepositoryImpl(val newService: NewsService): NewsRepository {
    override suspend fun getTpHeadlines(category: String, apiKey: String): NewsResponse {
        val responseDTO = newService.getTopHeadlines(category, apiKey)
        return responseDTO.toNews()
    }

    private fun NewsResponseDTO.toNews(): NewsResponse {
        return NewsResponse(
            status = status,
            totalResult = totalResults,
            articles = articles.map { it.toArticle() }
        )
    }

    private fun NewsResponseDTO.ArticleDTO.toArticle(): Article {
        return Article(
            source = source.toSource(),
            author = author,
            title = title,
            description = description,
            articleUrl = articleUrl,
            imageUrl = urlToImage,
            publishedAt = publishedAt,
            content = content
        )
    }

    private fun NewsResponseDTO.ArticleDTO.SourceDTO.toSource(): Source {
        return Source(
            id = id,
            name = name
        )
    }
}