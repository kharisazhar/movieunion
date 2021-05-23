package com.dicoding.movieunion

import android.app.Application
import com.dicoding.movieunion.core.di.networkModule
import com.dicoding.movieunion.core.di.repositoryModule
import com.dicoding.movieunion.core.di.useCaseModule
import com.dicoding.movieunion.core.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(listOf(networkModule, viewModelModule, repositoryModule, useCaseModule))
        }
    }
}