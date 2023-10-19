package di

import org.koin.dsl.module
import ui.MainViewModel

val appModule = module {
    // single { MainRepositoryImpl(get()) }
    viewModelDefinition { MainViewModel(get())}
}