package com.example.rongyi.baseandroidmodel

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.RemoteViews
import kotlinx.android.synthetic.main.activity_second.*


/**
 * Created by rongyi on 2017/6/26.
 */
class Second : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        /*tvTitle.text = BuildConfig.BUILD_TYPE

        tvTitle.setOnClickListener {
            notification2()
        }*/

        fab.setOnClickListener {
            val username = tl_username.editText!!.text.toString()
            val password = tl_password.editText!!.text.toString()
            if (username.length < 6) {
                tl_username.isErrorEnabled = true
                tl_username.error = "请输入正确账号"
            } else if ("admin" != password) {
                tl_password.isErrorEnabled = true
                tl_password.error = "密码错误"
            } else {
                tl_username.isErrorEnabled = false
                tl_password.isErrorEnabled = false
                notification2("登录成功")

                /*val uri = Uri.parse("myappx://cn.yikwing.kotlin:9999")
                val intent = Intent("android.kotlin.top")
                intent.data = uri
                startActivity(intent)*/
            }
        }

    }


    /**
     * builder.setVisibility(Notification.VISIBILITY_PUBLIC);  //通知等级
     * VISIBILITY_PUBLIC: 任何情况的显示
     * VISIBILITY_PRIVATE: 只有在没有锁屏时显示
     * VISIBILITY_SECRET: 在安全锁下或者没锁屏下显示
     * */
    fun notification2(s: String) {
        val mNotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val builder = Notification.Builder(this);
        val intent = Intent("android.kotlin.top")
        val uri = Uri.parse("myappx://cn.yikwing.kotlin:9999")
        intent.data = uri
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)
        builder.setContentIntent(pendingIntent)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                .setAutoCancel(true)
                .setContentTitle(s)

        val XuanIntent = Intent();
        XuanIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        XuanIntent.setClass(this, MainActivity::class.java)

        val xuanpengdIntent = PendingIntent.getActivity(this, 0, XuanIntent, PendingIntent.FLAG_CANCEL_CURRENT);
        builder.setFullScreenIntent(xuanpengdIntent, true);
        builder.setVisibility(Notification.VISIBILITY_PUBLIC);    //设置通知的等级
        mNotificationManager.notify(2, builder.build());

    }

    //自定义+通知栏
    fun notification1() {
        val mNotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val builder = Notification.Builder(this)
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.jianshu.com/p/82e249713f1b"))
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)

        builder.setContentIntent(pendingIntent)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher))
                .setAutoCancel(true)
                .setContentTitle("折叠通知")

        val remoteViews = RemoteViews(getPackageName(), R.layout.layout_view);
        val build = builder.build()
        build.bigContentView = remoteViews
        mNotificationManager.notify(1, build)

    }


    //普通+通知栏
    fun notification() {

        val mNotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val builder = Notification.Builder(this)
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.jianshu.com/p/82e249713f1b"))
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)

        builder.setContentIntent(pendingIntent)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher))
                .setAutoCancel(true)
                .setContentTitle("普通通知")
        mNotificationManager.notify(1, builder.build())
    }
}