package com.love.rxjavademo.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.love.rxjavademo.R;
import com.wx.wheelview.adapter.ArrayWheelAdapter;
import com.wx.wheelview.widget.WheelView;

import java.util.ArrayList;
import java.util.List;

public class ScrollViewActivity extends BaseActivity {

    WheelView wheelView;
    WheelView wheelView1;
    WheelView wheelView2;


    List<String> list;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_scroll_view;
    }

    @Override
    protected void findView() {
        wheelView = (WheelView) findViewById(R.id.wheelview);
        wheelView1 = (WheelView) findViewById(R.id.wheelview1);
        wheelView2 = (WheelView) findViewById(R.id.wheelview2);

    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        init();

        wheelView.setWheelAdapter(new ArrayWheelAdapter(this)); // 文本数据源
        wheelView.setSkin(WheelView.Skin.Holo); // common皮肤
        wheelView.setWheelData(list);  // 数据集合
        wheelView.setWheelClickable(true);

        wheelView1.setWheelAdapter(new ArrayWheelAdapter(this)); // 文本数据源
        wheelView1.setSkin(WheelView.Skin.Holo); // common皮肤
        wheelView1.setWheelData(list);  // 数据集合
        wheelView1.setWheelClickable(true);

        wheelView2.setWheelAdapter(new ArrayWheelAdapter(this)); // 文本数据源
        wheelView2.setSkin(WheelView.Skin.Holo); // common皮肤
        wheelView2.setWheelData(list);  // 数据集合
        wheelView2.setWheelClickable(true);

        wheelView.setOnWheelItemSelectedListener(new WheelView.OnWheelItemSelectedListener() {
            @Override
            public void onItemSelected(int position, Object o) {
                Log.e("lee", position + "");
            }
        });

        wheelView.setOnWheelItemClickListener(new WheelView.OnWheelItemClickListener() {
            @Override
            public void onItemClick(int position, Object o) {
                Toast.makeText(ScrollViewActivity.this, "" + position, Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void init() {

        list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i + "");
        }

    }
}
