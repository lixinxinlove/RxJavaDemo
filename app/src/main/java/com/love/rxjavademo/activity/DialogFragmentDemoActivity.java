package com.love.rxjavademo.activity;

import android.os.Bundle;
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
        DialogFragmentA dialogFragmentA = new DialogFragmentA();
        dialogFragmentA.show(getSupportFragmentManager(), "lee");
    }

}
