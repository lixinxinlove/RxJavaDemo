package com.love.rxjavademo.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.widget.Toast;

import com.love.rxjavademo.R;

public class LocalBroadcastActivity extends BaseActivity {


    private IntentFilter intentFilter;
    private LocalReceiver localReceiver;
    //本地广播数据类型实例。
    private LocalBroadcastManager localBroadcastManager;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_local_broadcast;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //获取本地广播实例。
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        //新建intentFilter并给其action标签赋值。
        intentFilter = new IntentFilter();
        intentFilter.addAction("com.love.rxjavademo.activity");

        //创建广播接收器实例，并注册。将其接收器与action标签进行绑定。
        localReceiver = new LocalReceiver();
        localBroadcastManager.registerReceiver(localReceiver, intentFilter);

    }


    public void sendBroadcast(View view) {
        Intent intent = new Intent("com.love.rxjavademo.activity");
        intent.putExtra("name", "lee");
        //发送本地广播。
        localBroadcastManager.sendBroadcast(intent);
    }

    @Override
    protected void findView() {

    }

    @Override
    protected void setListener() {

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //取消注册调用的是unregisterReceiver()方法，并传入接收器实例。
        localBroadcastManager.unregisterReceiver(localReceiver);
    }

    class LocalReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                Toast.makeText(context, intent.getStringExtra("name"), Toast.LENGTH_SHORT).show();
            }
            Toast.makeText(context, "这是本地广播接收器", Toast.LENGTH_SHORT).show();
        }
    }
}
