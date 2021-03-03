package com.blood.mactest.main

import android.app.Application
import kotlin.properties.Delegates

class MainApp : Application() {

    companion object {
        var instance: MainApp by Delegates.notNull()
        fun instance() = instance
        fun context() = instance.baseContext!!
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}