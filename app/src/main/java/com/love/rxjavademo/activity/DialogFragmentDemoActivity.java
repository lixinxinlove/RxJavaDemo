package com.love.rxjavademo.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.love.rxjavademo.R;
import com.love.rxjavademo.fragment.DialogFragmentA;

public class DialogFragmentDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_fragment_demo);
    }


    public void show(View v) {
        final DialogFragmentA dialogFragmentA = new DialogFragmentA();
        dialogFragmentA.show(getSupportFragmentManager(), "lee");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                dialogFragmentA.showKeyboard();
            }
        }, 200);


    }

}
