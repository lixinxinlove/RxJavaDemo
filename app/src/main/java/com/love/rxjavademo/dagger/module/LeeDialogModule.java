package com.love.rxjavademo.dagger.module;

import android.content.Context;

import com.lixinxin.leeview.dialog.LeeDialog;

import dagger.Module;
import dagger.Provides;

/**
 * Created by android on 2017/12/13.
 */
@Module
public class LeeDialogModule {

    private Context mContext;

    public LeeDialogModule(Context context) {
        this.mContext = context;
    }

    @Provides
    LeeDialog getLeeDialog() {
        return new LeeDialog(mContext);
    }
}
