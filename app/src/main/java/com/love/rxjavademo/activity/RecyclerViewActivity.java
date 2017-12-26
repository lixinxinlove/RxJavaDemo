package com.love.rxjavademo.activity;

import android.app.Service;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.callback.ItemDragAndSwipeCallback;
import com.chad.library.adapter.base.listener.OnItemDragListener;
import com.love.rxjavademo.R;
import com.love.rxjavademo.adapter.ItemDraggableAdapter;
import com.love.rxjavademo.view.MyItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends BaseActivity implements BaseQuickAdapter.OnItemChildClickListener {

    private RecyclerView recyclerView;

    private ItemDraggableAdapter adapter;

    private List<String> mDate;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_recycler_view;
    }

    @Override
    protected void findView() {
        recyclerView = (RecyclerView) findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new MyItemDecoration());
        initData();
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void setListener() {
        adapter.setOnItemChildClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void initData() {

        mDate = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            mDate.add("lee" + i);
        }
        adapter = new ItemDraggableAdapter(mDate);
        ItemDragAndSwipeCallback itemDragAndSwipeCallback = new ItemDragAndSwipeCallback(adapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(itemDragAndSwipeCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);

        // 开启拖拽
        adapter.enableDragItem(itemTouchHelper, R.id.btn, true);
        adapter.setOnItemDragListener(onItemDragListener);
        // 开启滑动删除
        //  adapter.enableSwipeItem();
        //  adapter.setOnItemSwipeListener(onItemSwipeListener);
    }

    OnItemDragListener onItemDragListener = new OnItemDragListener() {
        @Override
        public void onItemDragStart(RecyclerView.ViewHolder viewHolder, int pos) {
            Vibrator vib = (Vibrator) getSystemService(Service.VIBRATOR_SERVICE);
            if (vib.hasVibrator()) {
                vib.vibrate(50);
            }
            viewHolder.itemView.findViewById(R.id.root_layout).setBackgroundColor(Color.BLUE);
        }

        @Override
        public void onItemDragMoving(RecyclerView.ViewHolder source, int from, RecyclerView.ViewHolder target, int to) {
        }

        @Override
        public void onItemDragEnd(RecyclerView.ViewHolder viewHolder, int pos) {
            for (int i = 0; i < mDate.size(); i++) {
                Log.e("data", mDate.get(i));
            }
            viewHolder.itemView.findViewById(R.id.root_layout).setBackgroundColor(getResources().getColor(R.color.colorAccent));
        }
    };


    // 内部控件点击事件
    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        Toast.makeText(this, position + "", Toast.LENGTH_SHORT).show();
    }

//    OnItemSwipeListener onItemSwipeListener = new OnItemSwipeListener() {
//        @Override
//        public void onItemSwipeStart(RecyclerView.ViewHolder viewHolder, int pos) {
//        }
//
//        @Override
//        public void clearView(RecyclerView.ViewHolder viewHolder, int pos) {
//        }
//
//        @Override
//        public void onItemSwiped(RecyclerView.ViewHolder viewHolder, int pos) {
//        }
//
//        @Override
//        public void onItemSwipeMoving(Canvas canvas, RecyclerView.ViewHolder viewHolder, float dX, float dY, boolean isCurrentlyActive) {
//
//        }
//    };


}
