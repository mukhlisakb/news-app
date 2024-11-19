package com.mukhlisakb.newsapps.presentation.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mukhlisakb.newsapps.MyApplication
import com.mukhlisakb.newsapps.R
import com.mukhlisakb.newsapps.domain.entities.Article

private const val NEWS_CATEGORY = "category"

class ListFragment : Fragment(), NewsListEventListener {
    private var newsCategory: String? = null

    private lateinit var newsViewModel: NewsViewModel

    private var newsListAdapter = NewsListAdapter(this)
    private lateinit var rvNewsList: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            newsCategory = it.getString(NEWS_CATEGORY)
        }
        val appContainer = (requireActivity().application as? MyApplication)?.appContainer
        appContainer?.let {
            newsViewModel =
                ViewModelProvider(this, it.provideViewModelFactory())[NewsViewModel::class.java]
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initList()
        observeNewsList()
        newsViewModel.fetchTopHeadlines(category = newsCategory ?: "business")
    }

    private fun observeNewsList() {
        newsViewModel.newsLiveData.observe(viewLifecycleOwner) { result ->
            newsListAdapter.submitList(result.articles)
        }
    }

    private fun initList() {
        view?.let {
            rvNewsList = it.findViewById(R.id.rv_news_list)
            rvNewsList.adapter = newsListAdapter
            rvNewsList.layoutManager = LinearLayoutManager(context)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(category: String) =
            ListFragment().apply {
                arguments = Bundle().apply {
                    putString(NEWS_CATEGORY, category)
                }
            }
    }

    override fun onCardNewsClicked(article: Article) {
        val bundle = bundleOf("News" to article)
        findNavController().navigate(R.id.action_homeFragment_to_detailFragment, bundle)
    }
}