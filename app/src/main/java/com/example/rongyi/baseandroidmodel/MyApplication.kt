package com.example.rongyi.baseandroidmodel

import android.app.Application
import com.safframework.log.L

/**
 * Created by rongyi on 2017/6/22.
 */

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()


        /**
         *
         * @Description: 根据调试/正式环境,显示/隐藏Debug日志输出
         * @param:       if(true)显示所有日志
         * @Data:        2017/6/28 下午2:51
         * @author:      rongyi
         * @return:
         *
         */
        if (BuildConfig.SHOW_LOG) {
            L.logLevel = L.LogLevel.DEBUG
        } else {
            L.logLevel = L.LogLevel.INFO
        }
    }


}
