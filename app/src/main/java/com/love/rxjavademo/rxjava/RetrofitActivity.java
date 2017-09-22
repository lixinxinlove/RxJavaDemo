package com.love.rxjavademo.rxjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.love.rxjavademo.R;
import com.love.rxjavademo.bean.Girl;
import com.love.rxjavademo.bean.Result;
import com.love.rxjavademo.retrofit.RetrofitClient;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class RetrofitActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        textView = (TextView) findViewById(R.id.tv_text);
    }


    public void retrofit(View view) {
        RetrofitClient.getInstence().getGankService().getGirls(10, 1)
                .map(new Function<Result, List<Girl>>() {
                    @Override
                    public List<Girl> apply(@NonNull Result result) throws Exception {
                        Log.e("map", Thread.currentThread().getName());
                        if (!result.isError()) {
                            return result.getResults();
                        } else {
                            return null;
                        }
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Girl>>() {
                    @Override
                    public void accept(List<Girl> girls) throws Exception {

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }




    /*new Observer<List<Girl>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                    }

                    @Override
                    public void onNext(@NonNull List<Girl> girls) {
                        Log.e("onNext", Thread.currentThread().getName());
                        if (girls != null) {
                            for (Girl girl : girls) {
                                Log.e("gitl", girl.getUrl());
                            }
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                    }

                    @Override
                    public void onComplete() {
                    }
                }*/


}
