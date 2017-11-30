package com.love.rxjavademo.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.love.rxjavademo.R;
import com.love.rxjavademo.cache.DiskLruCacheHelper;

import java.io.IOException;

public class CacheActivity extends BaseActivity {

    private DiskLruCacheHelper mDiskLruCacheHelper;

    private TextView textView;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_cache;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            mDiskLruCacheHelper = new DiskLruCacheHelper(this);
        } catch (IOException e) {
            e.printStackTrace();
        }

        textView = (TextView) findViewById(R.id.tv);

    }

    @Override
    protected void findView() {

    }

    @Override
    protected void setListener() {

    }


    public void onSave(View view) {
        if (mDiskLruCacheHelper != null) {
            mDiskLruCacheHelper.put("key", "lixinxin");
            Toast.makeText(this, "保存成功", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "保存失败", Toast.LENGTH_LONG).show();
        }
    }

    public void onGet(View view) {
        String s = mDiskLruCacheHelper.getAsString("key");
        textView.setText(s);
    }

}
