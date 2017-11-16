package com.love.rxjavademo.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import com.love.rxjavademo.R;

import java.util.ArrayList;
import java.util.List;

public class ViewSwitcherActivity extends BaseActivity {
    private ViewSwitcher viewSwitcher;
    private Button btnSwitcher;


    private TextView tv1, tv2;

    private int pos = 0;
    MyHandler handler = new MyHandler();
    private List<String> list;

    private int listPos = 0;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_view_switcher;
    }

    @Override
    protected void findView() {
        viewSwitcher = (ViewSwitcher) findViewById(R.id.view_switcher);
        btnSwitcher = (Button) findViewById(R.id.btn_switcher);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
    }

    @Override
    protected void setListener() {

        btnSwitcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        viewSwitcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = viewSwitcher.getDisplayedChild();
                Toast.makeText(ViewSwitcherActivity.this, "第" + i + "个", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
        tv1.setText(list.get(0));

        Animation slide_in_left = AnimationUtils.loadAnimation(this, R.anim.slide_in_boom);
        Animation slide_out_right = AnimationUtils.loadAnimation(this, R.anim.slide_out_top);

        viewSwitcher.setInAnimation(slide_in_left);
        viewSwitcher.setOutAnimation(slide_out_right);
        handler.sendEmptyMessageDelayed(1, 2000);
    }

    private void initData() {
        list = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            list.add("i--->" + i);
        }
    }

    class MyHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                pos = pos == 0 ? 1 : 0;
                listPos++;
                listPos %= list.size();

                if (pos == 1) {
                    tv2.setText(list.get(listPos));
                } else {
                    tv1.setText(list.get(listPos));
                }
                viewSwitcher.setDisplayedChild(pos);
                handler.sendEmptyMessageDelayed(1, 2000);
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeMessages(1);
    }
}
