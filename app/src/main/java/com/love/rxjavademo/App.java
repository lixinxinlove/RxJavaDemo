package com.love.rxjavademo;

import android.app.Application;

import com.love.sdk.EventeCount;

/**
 * Created by android on 2017/9/22.
 */

public class App extends Application {

    public static App app;

    @Override
    public void onCreate() {
        super.onCreate();

        app = this;

        EventeCount.init(app);
    }

}
