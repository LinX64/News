package data.repository

import data.dataSource.NewsDataSource
import data.dataSource.NewsDataSourceImpl
import data.model.TopHeadlinesResponse
import data.util.Sources
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class NewsRepositoryImpl(
    private val newsDataSource: NewsDataSource,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : NewsRepository {

    override fun getTopHeadlines(): Flow<TopHeadlinesResponse> = flow {
        val topHeadlines = newsDataSource.getTopHeadlines()
        emit(topHeadlines)
    }.flowOn(ioDispatcher)

    override fun getTopHeadlinesByTopic(topic: String): Flow<TopHeadlinesResponse> = flow {
        val topHeadlines = newsDataSource.getTopHeadlines()
        emit(topHeadlines)
        // TODO
    }.flowOn(ioDispatcher)
}
