package com.love.rxjavademo.fragment.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

/**
 * Created by android on 2017/11/22.
 */

public abstract class BaseDialogFragment extends DialogFragment implements View.OnClickListener {

    protected View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);  //去掉标题
        rootView = inflater.inflate(getResId(), null);
        findView();
        setListener();
        return rootView;
    }


    protected abstract void setListener();

    protected abstract void findView();

    protected abstract int getResId();

    @Override
    public void onClick(View v) {

    }
}
