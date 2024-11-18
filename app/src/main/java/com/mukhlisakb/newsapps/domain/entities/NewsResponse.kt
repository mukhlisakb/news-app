package com.mukhlisakb.newsapps.domain.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class NewsResponse(
    val status: String,
    val totalResult: Int,
    val articles: List<Article>
): Parcelable

@Parcelize
data class Article(
    val source: Source,
    val author: String?,
    val title: String?,
    val description: String?,
    val articleUrl: String,
    val imageUrl: String?,
    val publishedAt: String,
    val content: String?
): Parcelable

@Parcelize
data class Source(
    val id: String?,
    val name: String
): Parcelable
