package com.love.rxjavademo.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.love.rxjavademo.R;
import com.love.rxjavademo.glide.MyAppGlideModule;

public class GlideActivity extends BaseActivity {


    ImageView imageView;
    TextView textView;
    String url = "https://ws1.sinaimg.cn/large/610dc034ly1fjqw4n86lhj20u00u01kx.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);
        imageView = (ImageView) findViewById(R.id.image);
        textView = (TextView) findViewById(R.id.tv_cache_size);
        textView.setText(MyAppGlideModule.getCacheSize(this));
    }


    public void loadImage(View v) {
        Glide.with(this).load(url).into(imageView);
        textView.setText(MyAppGlideModule.getCacheSize(this));
    }


    public void clearCache(View view) {

        new Thread(new Runnable() {
            @Override
            public void run() {

                Glide.get(GlideActivity.this).clearDiskCache();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText(MyAppGlideModule.getCacheSize(GlideActivity.this));
                    }
                });
            }
        }).start();

    }

}
