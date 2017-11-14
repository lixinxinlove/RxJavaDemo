package com.love.rxjavademo.activity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.love.rxjavademo.App;
import com.love.rxjavademo.R;

public class SQLiteActivity extends BaseActivity {

    @Override
    protected int getContentViewId() {
        return R.layout.activity_sqlite;
    }

    @Override
    protected void findView() {

    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SQLiteDatabase db = App.getmDBHelper().getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("bookName", "lixinxin");
        values.put("bookDesc", "lixinxin life");
        db.insert("study", null, values);  //插入
        //  db.delete("study", "_id = ?", new String[]{"2"}); //删除

        ContentValues values1 = new ContentValues();
        values1.put("bookName", "lee");

        db.update("study", values1, "_id = ?", new String[]{"2"}); //更新
    }
}
