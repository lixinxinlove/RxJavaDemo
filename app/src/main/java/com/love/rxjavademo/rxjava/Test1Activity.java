package com.love.rxjavademo.rxjava;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.love.rxjavademo.R;
import com.love.rxjavademo.activity.BaseActivity;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.Random;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class Test1Activity extends BaseActivity {

    TextView textView;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_test1;
    }

    @Override
    protected void findView() {

    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        textView = (TextView) findViewById(R.id.tv);
        textView.setText("");
    }

    public void subscribe(View v) {
        init2();
    }


    private void init() {
        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                Thread.sleep(2000);
                e.onNext(2);
                Thread.sleep(2000);
                e.onNext(3);
                e.onComplete();
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());


        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Integer integer) {
                textView.setText(textView.getText().toString() + integer);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };

        //订阅
        observable.subscribe(observer);

    }

    private void init2() {

        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> e) throws Exception {
                e.onNext("jj");
                //Thread.sleep(2000);
                e.onNext("jj");
                //   Thread.sleep(2000);
                e.onNext("jj");
                //  Thread.sleep(2000);
                e.onComplete();
            }
        }).map(new Function<String, String>() {
            @Override
            public String apply(@NonNull String s) throws Exception {
                return s + "lee";
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {

                    private Disposable mDisposable;

                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        mDisposable = d;
                    }

                    @Override
                    public void onNext(@NonNull String s) {
                        mDisposable.dispose(); //终止接受
                        textView.setText(textView.getText().toString() + s);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        textView.setText(textView.getText().toString() + "结束");
                    }
                });
    }


    private void init3() {
        Single.just(new Random().nextInt(100)).subscribe(new SingleObserver<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onSuccess(@NonNull Integer integer) {
                textView.setText(integer + "");
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }
        });
    }

    private void init4() {
        Flowable.create(new FlowableOnSubscribe<Integer>() {

            @Override
            public void subscribe(@NonNull FlowableEmitter<Integer> e) throws Exception {

            }
        }, BackpressureStrategy.ERROR).subscribe(new Subscriber<Integer>() {
            @Override
            public void onSubscribe(Subscription s) {

            }

            @Override
            public void onNext(Integer integer) {

            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {

            }
        });
    }


}
