package com.love.rxjavademo.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.love.rxjavademo.R;
import com.love.rxjavademo.adapter.MultipleItemQuickAdapter;
import com.love.rxjavademo.bean.MultipleItem;
import com.love.rxjavademo.view.CustomLoadMoreView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapterActivity extends BaseActivity implements BaseQuickAdapter.RequestLoadMoreListener,
        BaseQuickAdapter.OnItemChildClickListener {


    private MultipleItemQuickAdapter adapter;
    private RecyclerView recyclerView;
    private List<MultipleItem> mData;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_recycler_view_adpter;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        initData();

    }

    private void initData() {

        mData = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            MultipleItem item = new MultipleItem(i % 2);
            item.setText("lee" + i);
            item.setUrl("ll");
            mData.add(item);
        }
        adapter = new MultipleItemQuickAdapter(mData);
        //adapter.disableLoadMoreIfNotFullPage();
        adapter.setLoadMoreView(new CustomLoadMoreView());
        adapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        adapter.setEnableLoadMore(true);
        adapter.setOnLoadMoreListener(this, recyclerView);
        adapter.setOnItemChildClickListener(this);

        recyclerView.setAdapter(adapter);

    }

    @Override
    protected void findView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                adapter.setShowPoint(!adapter.isShow);
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.rv);

    }

    @Override
    protected void setListener() {

    }


    //加载跟多
    @Override
    public void onLoadMoreRequested() {


        recyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {

                if (mData.size() > 35) {
                    adapter.loadMoreEnd();
                } else {
                    MultipleItem item = new MultipleItem(0);
                    item.setText("加载更多");
                    item.setUrl("");
                    mData.add(item);
                    item.setItemType(1);

                    adapter.loadMoreComplete();
                }

            }
        }, 2000);
    }


    // item 点击事件
    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        switch (view.getId()) {
            case R.id.iv_image:
                Toast.makeText(this, "点击的是图片", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_text:
                Toast.makeText(this, "点击的是文本", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
