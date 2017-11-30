package com.love.rxjavademo;

import android.app.Application;

import com.love.rxjavademo.db.DBHelper;


/**
 * Created by android on 2017/9/22.
 */

public class App extends Application {

    public static App app;

    //数据库辅助类实例
    private static DBHelper mDBHelper;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        mDBHelper = new DBHelper(getApplicationContext());
    }

    //返回DBHelper实例，
    public static DBHelper getmDBHelper() {
        return mDBHelper;
    }

}
