package com.love.rxjavademo;

import android.app.Application;

import com.love.rxjavademo.db.DBHelper;

import io.objectbox.BoxStore;


/**
 * Created by android on 2017/9/22.
 */

public class App extends Application {

    public static App app;

    private static BoxStore boxStore;

    //数据库辅助类实例
    private static DBHelper mDBHelper;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        mDBHelper = new DBHelper(getApplicationContext());
       // boxStore = MyObjectBox.builder().androidContext(App.this).build();
    }

    //返回DBHelper实例，
    public static DBHelper getmDBHelper() {
        return mDBHelper;
    }


    public static BoxStore getBoxStore() {
        return boxStore;
    }
}
