package com.love.rxjavademo.util;

import android.util.Log;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by android on 2017/11/17.
 */

public class OkHttpUtils {

    private static OkHttpUtils instance;

    private static OkHttpClient okHttpClient;

    private static Interceptor interceptor;

    private Call call;

    public static synchronized OkHttpUtils getInstance() {
        if (instance == null) {
            interceptor = new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request request = chain.request();
                    Log.e("lee", "请求前");
                    Response response = chain.proceed(request);
                    //---------请求之后------------
                    Log.e("lee", "请求后");
                    return response;
                }
            };

            instance = new OkHttpUtils();
        }
        return instance;
    }


    private OkHttpUtils() {
        okHttpClient = new OkHttpClient.Builder()
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build();
    }

    public void get(String url, Callback callback) {
        Request request = new Request.Builder().url(url).get().build();
        call = okHttpClient.newCall(request);
        call.enqueue(callback);
    }


    public void post(String url, Map<String, String> map, Callback callback) {
        FormBody.Builder builder = new FormBody.Builder();

        for (String key : map.keySet()) {
            builder.add(key, map.get(key));
            Log.e("lee",key+"--"+map.get(key));
        }

        FormBody body = builder.build();

        Request request = new Request.Builder().url(url).post(body).build();
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
