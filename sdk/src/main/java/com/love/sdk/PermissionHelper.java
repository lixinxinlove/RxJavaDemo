package com.love.sdk;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v4.os.ResultReceiver;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by android on 2017/9/27.
 */

public class PermissionHelper {

    private static final String TAG = PermissionHelper.class.getSimpleName();


    public static <T extends Context & ActivityCompat.OnRequestPermissionsResultCallback> void requestPermissions(final T context, String[] permissions, int requestCode, String notificationTitle, String notificationText, int notificationIcon) {

        ResultReceiver resultReceiver = new ResultReceiver(new Handler(Looper.getMainLooper())) {
            @Override
            protected void onReceiveResult(int resultCode, Bundle resultData) {
                String[] outPermissions = resultData.getStringArray(Const.KEY_PERMISSIONS);
                int[] grantResults = resultData.getIntArray(Const.KEY_GRANT_RESULTS);
                context.onRequestPermissionsResult(resultCode, outPermissions, grantResults);
            }
        };

        Intent permIntent = new Intent(context, PermissionRequestActivity.class);
        permIntent.putExtra(Const.KEY_RESULT_RECEIVER, resultReceiver);
        permIntent.putExtra(Const.KEY_PERMISSIONS, permissions);
        permIntent.putExtra(Const.KEY_REQUEST_CODE, requestCode);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
        stackBuilder.addNextIntent(permIntent);

        PendingIntent permPendingIntent =
                stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setSmallIcon(notificationIcon)
                .setContentTitle(notificationTitle)
                .setContentText(notificationText)
                .setOngoing(true)
                //.setCategory(Notification.CATEGORY_STATUS)
                .setAutoCancel(true)
                .setWhen(0)
                .setContentIntent(permPendingIntent)
                .setStyle(null);

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(requestCode, builder.build());
    }


    /**
     * A blank {@link } on top of which permission request dialogs can be displayed
     */
    public static class PermissionRequestActivity extends AppCompatActivity {
        ResultReceiver resultReceiver;
        String[] permissions;
        int requestCode;


        @Override
        public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
            Bundle resultData = new Bundle();
            resultData.putStringArray(Const.KEY_PERMISSIONS, permissions);
            resultData.putIntArray(Const.KEY_GRANT_RESULTS, grantResults);
            resultReceiver.send(requestCode, resultData);
            finish();
        }


        @Override
        protected void onStart() {
            super.onStart();

            resultReceiver = this.getIntent().getParcelableExtra(Const.KEY_RESULT_RECEIVER);
            permissions = this.getIntent().getStringArrayExtra(Const.KEY_PERMISSIONS);
            requestCode = this.getIntent().getIntExtra(Const.KEY_REQUEST_CODE, 0);
            ActivityCompat.requestPermissions(this, permissions, requestCode);
        }
    }

}
