package di

import data.repository.MainRepositoryImpl
import org.koin.dsl.module
import ui.MainViewModel

fun appModule() = module {
    single { MainRepositoryImpl() }

    viewModelDefinition { MainViewModel() }
}