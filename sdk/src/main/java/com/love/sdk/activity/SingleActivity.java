package com.love.sdk.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.love.sdk.EventeCount;

public class SingleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_single);

        EventeCount.activity = this;
        EventeCount.request();
        finish();
       // moveTaskToBack(true);
    }
}
