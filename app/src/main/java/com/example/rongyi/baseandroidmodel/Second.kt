package com.example.rongyi.baseandroidmodel

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Window
import kotlinx.android.synthetic.main.activity_second.*
import android.R.transition
import android.R.transition.explode
import android.transition.TransitionInflater
import android.transition.Transition


/**
 * Created by rongyi on 2017/6/26.
 */
class Second : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        tvTitle.text = BuildConfig.BUILD_TYPE
    }
}