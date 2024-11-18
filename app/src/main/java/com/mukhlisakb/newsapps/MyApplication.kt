package com.mukhlisakb.newsapps

import android.app.Application
import com.mukhlisakb.newsapps.DI.AppContainer

class MyApplication: Application() {
    lateinit var appContainer: AppContainer
    override fun onCreate() {
        super.onCreate()
        appContainer = AppContainer()
    }
}