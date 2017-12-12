package com.love.rxjavademo.dagger.component;

import com.love.rxjavademo.activity.DaggerActivity;
import com.love.rxjavademo.dagger.module.UserEntityModule;

import dagger.Component;

/**
 * Created by android on 2017/12/12.
 */

@Component(modules = UserEntityModule.class)
public interface UserEntityComponent {
    void inject(DaggerActivity activity);
}
