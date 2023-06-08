package com.client.news.ui.data.repository

import com.client.news.ui.data.model.TopHeadlinesResponse
import kotlinx.coroutines.flow.Flow

interface MainRepository {

    suspend fun getTopHeadlines(): Flow<TopHeadlinesResponse>
}