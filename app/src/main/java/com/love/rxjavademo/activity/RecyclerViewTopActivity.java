package com.love.rxjavademo.activity;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;

import com.love.rxjavademo.R;
import com.love.rxjavademo.adapter.TopAdapter;

public class RecyclerViewTopActivity extends BaseActivity {

    private RecyclerView mRecyclerView;

    private RelativeLayout rlTopLayout;

    private TopAdapter adapter;

    private GridLayoutManager gridLayoutManager;

    private LinearLayoutManager linearLayoutManager;

    int mCurrentPosition = 0;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_recycler_view_top;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        linearLayoutManager = new LinearLayoutManager(this);
        gridLayoutManager = new GridLayoutManager(this, 2);
        adapter = new TopAdapter(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    protected void findView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.rv);
        rlTopLayout = (RelativeLayout) findViewById(R.id.rl_top_layout);
    }

    @Override
    protected void setListener() {
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            int firstVisibleItemPosition;

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                View view = linearLayoutManager.findViewByPosition(mCurrentPosition + 1);
                firstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
                if (view != null) {
                    if (firstVisibleItemPosition >= 1) {
                        rlTopLayout.setVisibility(View.VISIBLE);
                    } else {
                        rlTopLayout.setVisibility(View.INVISIBLE);
                    }
                }
            }
        });
    }

    private void updateTop() {
        rlTopLayout.setVisibility(View.VISIBLE);
    }
}
