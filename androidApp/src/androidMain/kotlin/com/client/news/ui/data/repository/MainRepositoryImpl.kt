package com.client.news.ui.data.repository

import com.client.news.ui.data.NewsApi
import com.client.news.ui.data.model.TopHeadlinesResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MainRepositoryImpl(
    private val api: NewsApi
) : MainRepository {

    override suspend fun getTopHeadlines(): Flow<TopHeadlinesResponse> = flow {
        val response = api.getTopHeadlines()
        emit(response)
    }
}
