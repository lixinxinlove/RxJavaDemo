package com.love.rxjavademo.activity;

import android.support.v7.app.AppCompatActivity;

import com.love.sdk.EventeCount;

/**
 * Created by android on 2017/9/27.
 */

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onResume() {
        super.onResume();
        EventeCount.onPageStart(this, this.getLocalClassName());
    }

    @Override
    protected void onPause() {
        super.onPause();
        EventeCount.onPageEnd(this, this.getLocalClassName());
    }

}
