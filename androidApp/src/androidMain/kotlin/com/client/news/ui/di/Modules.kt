package com.client.news.ui.di

import com.client.news.ui.data.repository.MainRepositoryImpl
import com.client.news.ui.ui.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { MainRepositoryImpl(get()) }
    viewModel { MainViewModel(get()) }
}