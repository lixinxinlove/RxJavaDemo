package com.love.rxjavademo.activity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.RemoteInput;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.love.rxjavademo.R;

public class MsgActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_msg);

        //[1]获取传递过来的Intent对象
        Intent intent = getIntent();
        //[2]解析传递过来的Intent对象
        Bundle bundle = RemoteInput.getResultsFromIntent(intent);
        //[3]解析传递过来的内容 需要密钥
        CharSequence content = bundle.getCharSequence("lee");
        //[4]显示内容
        Toast.makeText(this,content,Toast.LENGTH_LONG).show();
        System.out.println("content :"+content);

        //[5]获取一个NotificationMnager
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        //[6]创建一个新的Notification去处理 回复的Notification
        Notification notification = new Notification.Builder(this)
                .setSmallIcon(R.drawable.ic_select_all)
                .setContentText("回复完成")
                .build();
        //[7]发送这个Notificatio 注意 id 必须 要与 那个可回复的Notification ID 一致 如果不一样那么没有办法处理那个可回复的Notification
        mNotificationManager.notify(1,notification);

    }
}
