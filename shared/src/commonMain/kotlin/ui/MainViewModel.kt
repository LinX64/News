package ui

import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toLowerCase
import data.model.Article
import data.repository.NewsRepository
import data.util.Sources
import data.util.asResult
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class MainViewModel(
    mainRepository: NewsRepository
) : ViewModel() {

    val topHeadlines: StateFlow<TopHeadlinesState> = mainRepository.getTopHeadlines()
        .asResult()
        .map { result ->
            when (result) {
                is data.util.Result.Loading -> TopHeadlinesState.Loading
                is data.util.Result.Success -> TopHeadlinesState.Success(result.data.articles)
                is data.util.Result.Error -> {
                    TopHeadlinesState.Error(result.exception?.message ?: "Unknown error")
                }
            }
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000L),
            initialValue = TopHeadlinesState.Loading
        )

    fun getSources(): List<String> {
        val sources = Sources.entries
        val filteredNames = sources
            .map(Sources::name)
            .map { source ->
                source.replace("_", " ")
                    .toLowerCase(Locale.current)
                    .capitalize(Locale.current)
            }
        return filteredNames
    }
}

sealed interface TopHeadlinesState {
    data object Loading : TopHeadlinesState
    data class Success(val articles: List<Article>) : TopHeadlinesState
    data class Error(val error: String) : TopHeadlinesState
}