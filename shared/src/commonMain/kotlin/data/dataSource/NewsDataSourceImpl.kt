package data.dataSource

import data.model.TopHeadlinesResponse
import data.util.Consts
import data.util.Sources
import data.util.Sources.WALL_STREET_JOURNAL
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import kotlinx.serialization.json.Json

class NewsDataSourceImpl(private val client: HttpClient) : NewsDataSource {

    override suspend fun getTopHeadlines(): TopHeadlinesResponse {
        val response = getSpecificNewsBySource(Sources.TechCrunch.value)
        return Json.decodeFromString(response)
    }

    override suspend fun getWallStreetJournal(): TopHeadlinesResponse {
        val response = getSpecificNewsBySource(WALL_STREET_JOURNAL.value)
        return Json.decodeFromString(response)
    }

    private suspend fun getSpecificNewsBySource(source: String): String {
        return client.get(Consts.BASE_URL + source + Consts.API_KEY).bodyAsText()
    }
}