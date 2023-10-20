import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ui.components.NewsItem
import ui.components.NewsTopBar
import di.appModule
import org.koin.compose.KoinApplication
import org.koin.compose.koinInject
import ui.MainViewModel

@Composable
fun NewsApp(
    modifier: Modifier = Modifier
) {
    KoinApplication(application = {
        modules(appModule())
    }) {
        MaterialTheme {
            val snackBarHostState = remember { SnackbarHostState() }

            Scaffold(
                containerColor = Color.Transparent,
                contentColor = MaterialTheme.colorScheme.onBackground,
                snackbarHost = { SnackbarHost(snackBarHostState) },
                contentWindowInsets = WindowInsets(0, 0, 0, 0)
            ) {
                Column(modifier = modifier.fillMaxSize()) {
                    NewsTopBar()
                    MainContent()
                }
            }
        }
    }
}

@Composable
private fun MainContent(
    viewModel: MainViewModel = koinInject()
) {
    val lazyListState = rememberLazyGridState()
    LazyVerticalGrid(
        modifier = Modifier.fillMaxWidth(),
        state = lazyListState,
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(
            start = 12.dp,
            top = 16.dp,
            end = 12.dp,
            bottom = 16.dp
        ),
    ) {
        items(100) {
            NewsItem()
        }
    }
}