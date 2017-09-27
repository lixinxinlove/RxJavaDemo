package com.love.rxjavademo.rxjava;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.google.gson.Gson;
import com.love.rxjavademo.R;
import com.love.rxjavademo.activity.BaseActivity;
import com.love.rxjavademo.bean.Girl;
import com.love.rxjavademo.bean.Result;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpActivity extends BaseActivity {


    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp);
        progressBar = (ProgressBar) findViewById(R.id.pb);
    }

    public void rxjavaForHttp(View view) {
        init();
    }


    private void init() {

        progressBar.setVisibility(View.VISIBLE);

        Observable.create(new ObservableOnSubscribe<Response>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Response> e) throws Exception {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url("http://gank.io/api/data/福利/10/1")
                        .build();
                Call call = client.newCall(request);
                Response response = call.execute();
                e.onNext(response);
            }
        }).map(new Function<Response, Result>() {
            @Override
            public Result apply(@NonNull Response response) throws Exception {
                String json = response.body().string();
                Gson gson = new Gson();
                Result result = gson.fromJson(json, Result.class);
                return result;
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Result>() {
                    @Override
                    public void accept(Result result) throws Exception {
                        progressBar.setVisibility(View.GONE);
                        for (Girl girl : result.getResults()) {
                            Log.e("girl", girl.getUrl());
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        progressBar.setVisibility(View.GONE);
                        Log.e("girl", "失败");
                    }
                });
    }
}
