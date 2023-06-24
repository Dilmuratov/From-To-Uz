package com.example.fromtouzdemo.app

import android.app.Application
import com.example.fromtouzdemo.di.appModule
import com.example.fromtouzdemo.di.dataModule
import com.example.fromtouzdemo.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startTheKoin()
    }

    private fun startTheKoin() {
        startKoin {
            modules(listOf(appModule, dataModule, networkModule))
            androidContext(this@App)
        }
    }
}