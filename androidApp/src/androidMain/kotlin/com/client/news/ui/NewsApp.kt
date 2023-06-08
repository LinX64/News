package com.client.news.ui

import android.app.Application
import com.client.news.ui.di.appModule
import org.koin.core.context.GlobalContext.startKoin

class NewsApp : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin()
    }

    private fun initKoin() {
        startKoin {
            modules(appModule)
        }
    }
}