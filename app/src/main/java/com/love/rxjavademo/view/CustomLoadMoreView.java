package com.love.rxjavademo.view;

import com.chad.library.adapter.base.loadmore.LoadMoreView;
import com.love.rxjavademo.R;


/**
 * Created by android on 2017/11/15.
 */

public class CustomLoadMoreView extends LoadMoreView {
    @Override
    public int getLayoutId() {
        return R.layout.loading_layout;
    }

    @Override
    protected int getLoadingViewId() {
        return R.id.rl_loading;
    }

    @Override
    protected int getLoadFailViewId() {
        return R.id.rl_load_f;
    }

    @Override
    protected int getLoadEndViewId() {
        return R.id.rl_load_end;
    }
}
