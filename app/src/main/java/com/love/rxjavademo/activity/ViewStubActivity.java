package com.love.rxjavademo.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewStub;

import com.love.rxjavademo.R;

import java.lang.ref.WeakReference;

public class ViewStubActivity extends BaseActivity {


    private MyHandler handler = new MyHandler(this);
    ViewStub viewStub;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_view_stub;
    }

    @Override
    protected void findView() {

    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewStub = (ViewStub) findViewById(R.id.view_stub);
        //viewStub.inflate(); //加载布局
        viewStub.setVisibility(View.VISIBLE);


        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(3000);
                    handler.sendEmptyMessage(1);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            viewStub.setVisibility(View.GONE);
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    private static class MyHandler extends Handler {

        private WeakReference<ViewStubActivity> wRef;

        private MyHandler(ViewStubActivity pActivity) {
            this.wRef = new WeakReference<>(pActivity);
        }

        @Override
        public void handleMessage(Message msg) {
            ViewStubActivity activity = wRef.get();
            if (activity != null) {

                if (msg.what == 1) {

                }
            }

        }
    }

}
