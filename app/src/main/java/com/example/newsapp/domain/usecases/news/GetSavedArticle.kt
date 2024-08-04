package com.example.newsapp.domain.usecases.news

import com.example.newsapp.data.local.NewsDao
import com.example.newsapp.domain.model.Article
import javax.inject.Inject


class GetSavedArticle @Inject constructor(
    private val newsDao: NewsDao
) {

    suspend operator fun invoke(url: String): Article?{
        return newsDao.getArticle(url = url)
    }

}