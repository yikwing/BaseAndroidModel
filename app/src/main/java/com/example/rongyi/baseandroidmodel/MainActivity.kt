package com.example.rongyi.baseandroidmodel

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.util.Pair
import android.support.v4.view.ViewCompat
import android.support.v7.app.AppCompatActivity
import android.transition.TransitionInflater
import android.view.View
import android.view.Window
import android.view.WindowManager
import com.safframework.log.L
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //转场动画
        transitionAnimation()
        setContentView(R.layout.activity_main)


        //禁用截屏键
        window.addFlags(WindowManager.LayoutParams.FLAG_SECURE)

        btnClick.text = BuildConfig.HOST
        btnClick.setOnClickListener {
            val intent = Intent(this, Second::class.java)
            L.i("AppName :" + resources.getString(R.string.app_name))

            //默认转场动画
             startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        }

    }

    /**
     *
     * @Description: 转场动画
     * @param:       [R.transition.fade] Transition文件夹
     * @Data:        2017/6/29 下午5:54
     * @author:      rongyi
     * @return:
     *
     */
    private fun transitionAnimation() {
        window.requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
        val explode = TransitionInflater.from(this).inflateTransition(R.transition.fade)
        //退出时使用
        window.exitTransition = explode
        //第一次进入时使用
        window.enterTransition = explode
        //再次进入时使用
        window.reenterTransition = explode
    }
}