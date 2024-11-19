package com.mukhlisakb.newsapps.presentation.list

import com.mukhlisakb.newsapps.domain.entities.Article

interface NewsListEventListener {
    fun onCardNewsClicked(article: Article)
}