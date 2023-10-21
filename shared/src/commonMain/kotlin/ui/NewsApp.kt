package ui

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
import ui.main.components.NewsTopBar
import di.appModule
import di.networkModule
import org.koin.compose.KoinApplication
import org.koin.compose.koinInject
import ui.main.MainScreen

@Composable
fun NewsApp(
    modifier: Modifier = Modifier
) {
    KoinApplication(application = {
        modules(appModule, networkModule)
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
                    MainScreen()
                }
            }
        }
    }
}