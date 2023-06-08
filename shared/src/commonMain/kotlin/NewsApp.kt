
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import components.NewsItem
import components.NewsTopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsApp(
    modifier: Modifier = Modifier,
   // viewModel: MainViewModel
) {
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
                //MainContent(viewModel = viewModel)
            }
        }
    }
}

@Composable
private fun MainContent(
    //viewModel: MainViewModel
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

expect fun getPlatformName(): String