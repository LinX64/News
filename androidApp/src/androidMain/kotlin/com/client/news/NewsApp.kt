package com.client.news

import android.app.Application
import di.appModule
import org.koin.core.context.GlobalContext.startKoin

class NewsApp : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin()
    }

    private fun initKoin() {
        startKoin {
            // modules(appModule)
        }
    }
}