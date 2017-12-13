package com.love.rxjavademo.dagger.module;

import com.love.rxjavademo.bean.UserEntity;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by android on 2017/12/12.
 */
@Module
public class UserEntityModule {

    @Singleton   //设置单利
    @Provides
    UserEntity getUser() {
        return new UserEntity("lllll", 22, "三里屯");
    }

}
