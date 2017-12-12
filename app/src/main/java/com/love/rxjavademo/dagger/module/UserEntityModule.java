package com.love.rxjavademo.dagger.module;

import com.love.rxjavademo.bean.UserEntity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by android on 2017/12/12.
 */

@Module
public class UserEntityModule {

    @Provides
    UserEntity getUser() {
        return new UserEntity("lixinxin", 22, "三里屯");
    }
}
