package com.mukhlisakb.newsapps.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mukhlisakb.newsapps.domain.entities.NewsResponse
import com.mukhlisakb.newsapps.domain.usecase.GetTopHeadlinesUseCase
import kotlinx.coroutines.launch

class NewsViewModel(private val getTopHeadlinesUseCase: GetTopHeadlinesUseCase) : ViewModel() {
    private val _newsLiveData = MutableLiveData<NewsResponse>()
    val newsLiveData: LiveData<NewsResponse> = _newsLiveData

    private val apiKey = "5b92912264c64b86a5b36834a7b022f1"

    fun fetchTopHeadlines(category: String) {
        viewModelScope.launch {
            try {
                val news = getTopHeadlinesUseCase.invoke(category, apiKey)
                _newsLiveData.value = news
            } catch (t: Throwable) {
                t.printStackTrace()
            }
        }
    }
}