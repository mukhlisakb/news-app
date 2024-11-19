package com.mukhlisakb.newsapps.presentation.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mukhlisakb.newsapps.R
import com.mukhlisakb.newsapps.domain.entities.Article

class NewsListAdapter(val listener: NewsListEventListener) : ListAdapter<Article, NewsListAdapter.ArticleViewHolder>(DifUtilCallback()) {
    inner class ArticleViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(article: Article) {
            val newsParentView = itemView.findViewById<ConstraintLayout>(R.id.cl_news_parent)
            val newsImage = itemView.findViewById<ImageView>(R.id.iv_news_image)
            val newsDate = itemView.findViewById<TextView>(R.id.tv_news_date)
            val newsTitle = itemView.findViewById<TextView>(R.id.tv_news_title)
            val newsBrief = itemView.findViewById<TextView>(R.id.tv_news_brief)

            Glide.with(itemView)
                .load(article.imageUrl)
                .into(newsImage)
            newsDate.text = article.publishedAt
            newsTitle.text = article.title
            newsBrief.text = article.description

            newsParentView.setOnClickListener {
                listener.onCardNewsClicked(article)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_news_list, parent, false)
        return ArticleViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

}