package com.love.rxjavademo.activity;

import android.os.Bundle;
import android.util.Log;

import com.lixinxin.leeview.dialog.LeeDialog;
import com.love.rxjavademo.R;
import com.love.rxjavademo.bean.UserEntity;
import com.love.rxjavademo.dagger.component.DaggerUserEntityComponent;
import com.love.rxjavademo.dagger.module.LeeDialogModule;
import com.love.rxjavademo.dagger.module.UserEntityModule;

import javax.inject.Inject;

public class DaggerActivity extends BaseActivity {

    @Inject
    UserEntity userEntity;


    @Inject
    UserEntity userEntity1;


    @Inject
    LeeDialog leeDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerUserEntityComponent.builder().leeDialogModule(new LeeDialogModule(this)).userEntityModule(new UserEntityModule()).build().lixinxin(this);


        userEntity.setUserName("lee");

        leeDialog.show();

        Log.e("DaggerActivity", userEntity.toString());
        Log.e("DaggerActivity", userEntity1.toString());
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
