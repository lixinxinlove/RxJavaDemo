package com.love.rxjavademo.activity;

import android.os.Bundle;
import android.os.Environment;
import android.widget.Toast;

import com.love.rxjavademo.R;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okio.BufferedSink;
import okio.Okio;
import okio.Source;

public class OkIoActivity extends BaseActivity {


    private OkHttpClient okHttpClient;

    private String imageUrl = "http://7xi8d6.com1.z0.glb.clouddn.com/20171025112955_lmesMu_katyteiko_25_10_2017_11_29_43_270.jpeg";

    @Override
    protected int getContentViewId() {
        return R.layout.activity_ok_io;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        okHttpClient = new OkHttpClient.Builder()
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .build();
        final Request request = new Request.Builder().url(imageUrl).get().build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String filePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + "lee.jpeg";
                File file = new File(filePath);
                BufferedSink sink = Okio.buffer(Okio.sink(file));
                Source source = response.body().source();
                sink.writeAll(source);
                sink.flush();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(OkIoActivity.this, "下载成功", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });


    }

    @Override
    protected void findView() {

    }

    @Override
    protected void setListener() {

    }
}
