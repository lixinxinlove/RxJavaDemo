package com.love.rxjavademo.util;

import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by android on 2017/11/17.
 */

public class OkHttpUtils {

    private static OkHttpUtils instance;

    private static OkHttpClient okHttpClient;

    private Call call;

    public static synchronized OkHttpUtils getInstance() {
        if (instance == null) {
            instance = new OkHttpUtils();
        }
        return instance;
    }


    private OkHttpUtils() {
        okHttpClient = new OkHttpClient.Builder()
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .build();
    }

    public void get(String url, Callback callback) {
        Request request = new Request.Builder().url(url).get().build();
        call = okHttpClient.newCall(request);
        call.enqueue(callback);
    }

    public void cancel() {
        if (call != null) {
            if (!call.isCanceled()) {
                call.cancel();
            }
        }
    }

}
