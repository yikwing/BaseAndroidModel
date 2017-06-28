package com.example.rongyi.baseandroidmodel

import android.app.Application
import com.safframework.log.L

/**
 * Created by rongyi on 2017/6/22.
 */

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.SHOW_LOG) {
            L.logLevel = L.LogLevel.DEBUG
        } else {
            L.logLevel = L.LogLevel.INFO
        }
    }


}
