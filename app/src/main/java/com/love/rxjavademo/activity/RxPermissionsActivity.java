package com.love.rxjavademo.activity;

import android.Manifest;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.love.rxjavademo.R;
import com.tbruyelle.rxpermissions2.RxPermissions;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public class RxPermissionsActivity extends AppCompatActivity {

    RxPermissions rxPermissions;

    public static final String TAG = "RxPermissionsActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_permissions);
        rxPermissions = new RxPermissions(this); // where this is an Activity instance
    }


    public void permission(View view) {


        rxPermissions
                .request(Manifest.permission.CAMERA)
                .subscribe(new Observer<Boolean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Boolean aBoolean) {

                        if (aBoolean) {
                            Toast.makeText(RxPermissionsActivity.this, "有权限", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(RxPermissionsActivity.this, "没有权限", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}