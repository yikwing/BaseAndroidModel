## Android转场动画

- Explode效果(爆炸效果)
    ```
    <explode xmlns:android="http://schemas.android.com/apk/res/android"
        android:duration="300" />
    ```

- Slide效果(滑动效果)
    ```
    // slideEdge表示起始滑动的侧边位置，end表示右侧，start表示左侧，top表示顶部，bottom表示底侧
    <slide xmlns:android="http://schemas.android.com/apk/res/android"
        android:interpolator="@android:interpolator/decelerate_cubic"
        android:slideEdge="end"/>

    // 不希望顶部的状态栏以及底部的导航栏一起执行动画
    <slide xmlns:android="http://schemas.android.com/apk/res/android"
        android:interpolator="@android:interpolator/decelerate_cubic"
        android:slideEdge="end">
        <targets>
            <target android:excludeId="@android:id/navigationBarBackground" />
            <target android:excludeId="@android:id/statusBarBackground" />
        </targets>
    </slide>
    ```

- Fade效果(淡化效果)
    ```
    <fade xmlns:android="http://schemas.android.com/apk/res/android"
        android:duration="300" />
    ```

- Shared Element效果(共享元素效果)  
    1.将两个Activity中需要过渡的View加上android:transitionName属性,两个View的android:transitionName属性取值要一致
    ```
    <?xml version="1.0" encoding="utf-8"?>
    <RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
        android:layout_width="match_parent"
        android:layout_height="match_parent">
    
        <View
            android:id="@+id/firstSharedView"
            android:layout_width="100dp"
            android:layout_height="100dp"
            android:background="#00cc00"
            android:onClick="onClick"
            android:transitionName="sharedView" />
    </RelativeLayout>
    
    // 两个View都添加android:transitionName属性，并且取名一致。
    
    <?xml version="1.0" encoding="utf-8"?>
    <RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
        android:layout_width="match_parent"
        android:layout_height="match_parent">
    
        <View
            android:layout_width="match_parent"
            android:layout_height="300dp"
            android:layout_alignParentBottom="true"
            android:background="#00cc00"
            android:onClick="onClick"
            android:transitionName="sharedView" />    
    </RelativeLayout>
    ```
    2.调用startActivity
    ```
    startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this, firstSharedView, "sharedView").toBundle());
    ```
    3.多个共享元素,需要用到Pair( )可变参数
    ```
    val first: Pair<View, String> = Pair(btnClick, ViewCompat.getTransitionName(btnClick))
    val last: Pair<View, String> = Pair(btnClick2, ViewCompat.getTransitionName(btnClick2))
    val transitionActivityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(this, first, last)
    ActivityCompat.startActivity(this, intent, transitionActivityOptions.toBundle());
    ```



