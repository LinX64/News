package data.repository

import data.model.TopHeadlinesResponse
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    fun getTopHeadlines(): Flow<TopHeadlinesResponse>
    fun getTopHeadlinesByTopic(topic: String): Flow<TopHeadlinesResponse>
}