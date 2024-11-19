package com.mukhlisakb.newsapps.presentation.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.mukhlisakb.newsapps.R
import com.mukhlisakb.newsapps.domain.entities.Article


class DetailFragment : Fragment() {
    private lateinit var news: Article
    private val btnBackArrow by lazy { view?.findViewById<ImageView>(R.id.iv_back_arrow) }
    private val tvNewsTitle by lazy { view?.findViewById<TextView>(R.id.tv_news_title) }
    private val tvNewsDate by lazy { view?.findViewById<TextView>(R.id.tv_news_date) }
    private val ivNewsImage by lazy { view?.findViewById<ImageView>(R.id.iv_news_image) }
    private val tvNewsContent by lazy { view?.findViewById<TextView>(R.id.tv_news_content) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        news = arguments?.getParcelable<Article>("News") as Article
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnBackArrow?.setOnClickListener { findNavController().navigateUp() }
        tvNewsTitle?.text = news.title
        tvNewsDate?.text = news.publishedAt
        ivNewsImage?.let { Glide.with(this).load(news.imageUrl).into(it) }
        tvNewsContent?.text = news.content
    }
}