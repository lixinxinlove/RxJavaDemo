package com.love.rxjavademo.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by android on 2017/11/14.
 */

public class DBHelper extends SQLiteOpenHelper {

    //数据库名称
    private static final String DBName = "study.db";
    //数据库版本号
    private static final int DBVersion = 1;


    public DBHelper(Context context) {
        super(context, DBName, null, DBVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE study ( _id integer PRIMARY KEY AUTOINCREMENT NOT NULL, bookName varchar, bookDesc varchar)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
