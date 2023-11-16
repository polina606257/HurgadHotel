package com.example.hurgadhotel.app

import android.app.Application
import com.example.hurgadhotel.di.appModule
import com.example.hurgadhotel.di.dataModule
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            modules(listOf(appModule, dataModule))
        }
    }
}