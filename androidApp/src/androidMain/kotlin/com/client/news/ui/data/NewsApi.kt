package com.client.news.ui.data

import com.client.news.ui.data.model.TopHeadlinesResponse
import retrofit2.http.GET

interface NewsApi {

    @GET("top-headlines?")
    suspend fun getTopHeadlines(): TopHeadlinesResponse
}
