package com.printec_example.app

import android.app.Application
import com.printec_example.repository.Build

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Build.init(this)
    }

}