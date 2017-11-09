package com.love.rxjavademo.activity;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.love.rxjavademo.ex.AppManager;


/**
 * Created by android on 2017/9/27.
 */

public abstract class BaseActivity extends AppCompatActivity {


    private final String TAG1 = getClass().getName();

    @LayoutRes
    protected abstract int getContentViewId();

    protected abstract void findView();

    protected abstract void setListener();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        AppManager.getAppManager().addActivity(this);
        findView();
        setListener();

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppManager.getAppManager().remoreActivity(this);
    }
}
