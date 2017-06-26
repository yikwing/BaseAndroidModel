package com.example.rongyi.baseandroidmodel

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager
import com.orhanobut.logger.Logger
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //禁用截屏键
        window.addFlags(WindowManager.LayoutParams.FLAG_SECURE)

        btnClick.text = BuildConfig.HOST
        btnClick.setOnClickListener {
            val intent = Intent(this, Second::class.java)
            startActivity(intent)
        }

        Logger.d("123")
    }
}