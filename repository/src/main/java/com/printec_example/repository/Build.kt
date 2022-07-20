package com.printec_example.repository

import android.content.Context
import com.baraka.db.DBBuild
import com.printec_example.network.Build

object Build {

    fun init(appContext: Context) {
        Build.init(appContext)
        DBBuild.build(appContext)
    }

}