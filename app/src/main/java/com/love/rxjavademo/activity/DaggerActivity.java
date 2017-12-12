package com.love.rxjavademo.activity;

import android.os.Bundle;
import android.util.Log;

import com.love.rxjavademo.R;
import com.love.rxjavademo.bean.UserEntity;
import com.love.rxjavademo.dagger.component.DaggerUserEntityComponent;

import javax.inject.Inject;

public class DaggerActivity extends BaseActivity {

    @Inject
    UserEntity userEntity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerUserEntityComponent.create().lixinxin(this);
        Log.e("DaggerActivity", userEntity.toString());
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_dagger;
    }

    @Override
    protected void findView() {

    }

    @Override
    protected void setListener() {

    }

}
