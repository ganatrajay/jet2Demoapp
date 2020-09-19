package com.example.jet2demoapp.config

import android.app.Application
import com.example.jet2demoapp.api.mainModule
import org.koin.android.ext.android.startKoin

class Jet2Application : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this,
            listOf(mainModule),
            loadPropertiesFromFile = true)
    }
}