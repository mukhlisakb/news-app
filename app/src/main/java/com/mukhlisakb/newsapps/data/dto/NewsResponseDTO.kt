package com.mukhlisakb.newsapps.data.dto

import android.icu.text.CaseMap.Title
import com.google.gson.annotations.SerializedName

data class NewsResponseDTO(
    @SerializedName("status")
    val status: String,
    @SerializedName("totalResults")
    val totalResults: Int,
    @SerializedName("articles")
    val articles: List<ArticleDTO>
) {

    data class ArticleDTO (
        @SerializedName("source")
        val source: SourceDTO,
        @SerializedName("author")
        val author: String?,
        @SerializedName("title")
        val title: String?,
        @SerializedName("description")
        val description: String,
        @SerializedName("url")
        val articleUrl: String,
        @SerializedName("urlToImage")
        val urlToImage: String?,
        @SerializedName("publishedAt")
        val publishedAt: String,
        @SerializedName("content")
        val content: String?
    )
    {
        data class SourceDTO(
            @SerializedName("id")
            val id: String?,
            @SerializedName("name")
            val name: String,
        )
    }
}
