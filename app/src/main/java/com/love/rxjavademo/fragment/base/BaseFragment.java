package com.love.rxjavademo.fragment.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by android on 2017/12/19.
 */

public abstract class BaseFragment extends Fragment {


    protected View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(layoutId(), null);
        findView();
        setEvent();
        _onCreateView();
        return rootView;
    }

    @LayoutRes
    protected abstract int layoutId();

    protected abstract void _onCreateView();

    protected abstract void findView();

    protected abstract void setEvent();




}
