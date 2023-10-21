package di

import data.dataSource.NewsDataSource
import data.dataSource.NewsDataSourceImpl
import data.repository.NewsRepository
import data.repository.NewsRepositoryImpl
import io.ktor.client.HttpClient
import org.koin.dsl.module
import ui.MainViewModel

val appModule = module {
    viewModelDefinition { MainViewModel(get()) }
}

val networkModule = module {
    factory { HttpClient() }
    single<NewsDataSource> { NewsDataSourceImpl(get()) }

    // Repository
    single<NewsRepository> { NewsRepositoryImpl(get()) }
}