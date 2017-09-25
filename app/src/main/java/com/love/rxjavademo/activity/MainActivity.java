package com.love.rxjavademo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.love.rxjavademo.R;
import com.love.rxjavademo.glide.GlideApp;
import com.love.rxjavademo.rxjava.OkHttpActivity;
import com.love.rxjavademo.rxjava.RetrofitActivity;
import com.love.rxjavademo.rxjava.RxJavaActivity;
import com.love.rxjavademo.rxjava.Test1Activity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void test1(View view) {
        startActivity(new Intent(this, Test1Activity.class));
    }

    public void okHttp(View view) {
        startActivity(new Intent(this, OkHttpActivity.class));
    }

    public void retrofit(View view) {
        startActivity(new Intent(this, RetrofitActivity.class));
    }

    public void rxBus(View view) {
        startActivity(new Intent(this, RxJavaActivity.class));
    }

    public void put(View view) {
        startActivity(new Intent(this, RecyclerViewActivity.class));
    }

    public void glide(View view) {
        startActivity(new Intent(this, GlideActivity.class));
    }


}
