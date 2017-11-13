package com.love.rxjavademo.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.love.rxjavademo.R;
import com.love.rxjavademo.RxSharedPreferences.RxSharedPreferences;

import io.reactivex.functions.Consumer;

public class RxSharedPreferencesActivity extends BaseActivity {

    TextView textView;

    RxSharedPreferences rxShared;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_rx_shared_preferences;
    }

    @Override
    protected void findView() {
        textView = (TextView) findViewById(R.id.tv);
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final SharedPreferences sharedPreferences = getSharedPreferences("prefs", Context.MODE_PRIVATE);
        rxShared = RxSharedPreferences.with(sharedPreferences);

    }


    public void save(View v) {

        rxShared.putString("key", "RxSharedPreferences").subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.e("lee", s);
            }
        });
    }

    public void get(View v) {

        rxShared.getString("key", "").subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                textView.setText(s);
            }
        });
    }

}
