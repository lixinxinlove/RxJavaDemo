package com.love.rxjavademo.activity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.RemoteViews;
import android.widget.Toast;

import com.love.rxjavademo.R;

import java.util.UUID;

public class NotificationActivity extends BaseActivity {


    private static final String ACTION_PLAY_TOGGLE = "LEE";
    private static final String ACTION_PLAY_CLOSE = "close";
    private static final int NOTIFICATION_ID = 111;
    private RemoteViews mContentViewSmall;

    private Broadcast broadcast;
    private IntentFilter filter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        broadcast = new Broadcast();

        filter = new IntentFilter();
        filter.addAction(ACTION_PLAY_TOGGLE);
        filter.addAction(ACTION_PLAY_CLOSE);
        registerReceiver(broadcast, filter);

    }

    NotificationManager notificationManager;
    Notification notification;

    public void onShow(View v) {
        // The PendingIntent to launch our activity if the user selects this notification
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, new Intent(this, MainActivity.class), 0);

        // Set the info for the views that show in the notification panel.
        notification = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)  // the status icon
                .setWhen(System.currentTimeMillis())  // the time stamp
                .setContentIntent(contentIntent)  // The intent to send when the entry is clicked
                .setCustomContentView(getSmallContentView())
                //  .setCustomBigContentView(getBigContentView())
                .setPriority(NotificationCompat.PRIORITY_MAX)
                .setOngoing(true)
                .build();

        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFICATION_ID, notification);

    }


    private RemoteViews getSmallContentView() {
        if (mContentViewSmall == null) {
            mContentViewSmall = new RemoteViews(getPackageName(), R.layout.remote_view_small);
            setUpRemoteView(mContentViewSmall);
        }
        return mContentViewSmall;
    }

    private void setUpRemoteView(RemoteViews remoteView) {
        remoteView.setImageViewResource(R.id.iv, R.mipmap.ic_launcher);
        remoteView.setTextViewText(R.id.tv_text, "lixinxin");
        remoteView.setOnClickPendingIntent(R.id.iv, getPendingIntent(ACTION_PLAY_TOGGLE));
        remoteView.setOnClickPendingIntent(R.id.tv_close, getPendingIntent(ACTION_PLAY_CLOSE));
    }


    private PendingIntent getPendingIntent(String action) {
        return PendingIntent.getBroadcast(this, 0, new Intent(action), 0);
    }


    private class Broadcast extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(ACTION_PLAY_TOGGLE)) {
                Toast.makeText(NotificationActivity.this, "点击", Toast.LENGTH_SHORT).show();
                updateRemoteView();
            } else if (intent.getAction().equals(ACTION_PLAY_CLOSE)) {
                notificationManager.cancel(NOTIFICATION_ID);
            }
        }
    }


    private void updateRemoteView() {
        mContentViewSmall.setTextViewText(R.id.tv_text, getUUID());
        mContentViewSmall.setImageViewResource(R.id.iv, R.mipmap.ic_girl);
        notificationManager.notify(NOTIFICATION_ID, notification);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(broadcast);
    }

    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }


}
