package com.mukhlisakb.newsapps.presentation.list

import androidx.recyclerview.widget.DiffUtil
import com.mukhlisakb.newsapps.domain.entities.Article

class DifUtilCallback : DiffUtil.ItemCallback<Article>() {
    override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem == newItem
    }
}