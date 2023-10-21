package data.dataSource

import data.model.TopHeadlinesResponse

interface NewsDataSource {
    suspend fun getTopHeadlines(): TopHeadlinesResponse
    suspend fun getWallStreetJournal(): TopHeadlinesResponse
}