package com.love.sdk.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.love.sdk.ThreadLocalManager;

/**
 * Created by android on 2017/10/20.
 */

public class BaseActivity extends AppCompatActivity {

    public void setRequestPermissionListener(RequestPermissionListener requestPermissionListener) {
        this.requestPermissionListener = requestPermissionListener;
    }

    public interface RequestPermissionListener {
        void onRequestPermissionListener(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults);
    }

    private RequestPermissionListener requestPermissionListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //将BaseActivity设置到Map集合中
        ThreadLocalManager.tl.set(BaseActivity.this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestPermissionListener != null) {
            requestPermissionListener.onRequestPermissionListener(requestCode, permissions, grantResults);
        }
    }
}
