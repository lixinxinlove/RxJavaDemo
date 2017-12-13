package com.love.rxjavademo.dagger.component;

import com.love.rxjavademo.activity.DaggerActivity;
import com.love.rxjavademo.dagger.module.LeeDialogModule;
import com.love.rxjavademo.dagger.module.UserEntityModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by android on 2017/12/12.
 */

@Singleton
@Component(modules = {LeeDialogModule.class, UserEntityModule.class})
public interface UserEntityComponent {
    void lixinxin(DaggerActivity activity);
}
