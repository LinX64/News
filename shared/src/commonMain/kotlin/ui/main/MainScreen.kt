package ui.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridScope
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import org.koin.compose.koinInject
import ui.MainViewModel
import ui.TopHeadlinesState
import ui.main.components.ArticleItem
import ui.main.components.SourceChip

@Composable
internal fun MainScreen(
    modifier: Modifier = Modifier,
    mainViewModel: MainViewModel = koinInject()
) {
    val topHeadlinesState by mainViewModel.topHeadlines.collectAsState()
    val state = rememberLazyStaggeredGridState()
    val sources = mainViewModel.getSources()

    LazyRow(
        modifier = modifier
            .fillMaxWidth(),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(sources.size) {
            val source = sources[it]
            SourceChip(
                name = source,
                onClick = { /* Do something! */ }
            )
        }
    }

    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Adaptive(300.dp),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalItemSpacing = 24.dp,
        modifier = Modifier.testTag("home:feed"),
        state = state,
    ) {
        mainContent(topHeadlinesState)
    }
}

private fun LazyStaggeredGridScope.mainContent(
    topHeadlinesState: TopHeadlinesState
) {
    when (topHeadlinesState) {
        is TopHeadlinesState.Loading -> Unit
        is TopHeadlinesState.Success -> {
            val articles = topHeadlinesState.articles
            items(articles.size) { index ->
                val article = articles[index]
                ArticleItem(article)
            }
        }

        is TopHeadlinesState.Error -> {
            val error = topHeadlinesState.error
            item {
                Text(text = error)
            }
        }
    }
}