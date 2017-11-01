package com.love.sdk;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.Toast;

import com.love.sdk.activity.SingleActivity;
import com.love.sdk.util.LocationUtils;
import com.love.sdk.util.Logger;
import com.love.sdk.util.PermissionsUtil;

import java.util.Timer;

/**
 * Created by android on 2017/9/27.
 */

public class EventeCount {

    private final static String TAG = "EventeCount";
    private static Context mContext;
    public static Activity activity;


    Timer timer = new Timer();



    public static void init(final Context context) {
        mContext = context;
        getLocation();
    }

    private static void getLocation() {
        if (PermissionsUtil.checkSinglePermissions(mContext, Manifest.permission.ACCESS_FINE_LOCATION)) {
            Log.e("EventeCount", "有权限");
            Location location = LocationUtils.getInstance(mContext).showLocation();
        } else {
            Log.e("EventeCount", "没有权限");
            Intent intent = new Intent(mContext, SingleActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            mContext.startActivity(intent);
        }
    }


    public static void request() {
        ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 100);
    }


    public static void execute() {
        Toast.makeText(mContext, "获取权限后", Toast.LENGTH_LONG).show();
        Location location = LocationUtils.getInstance(mContext).showLocation();
        if (location != null) {
            Log.e(TAG, location.getLatitude() + "--" + location.getLongitude());
        }
    }


    public void setDebugMode(boolean isDebug) {
        Logger.isDebug = isDebug;
    }


    public static void onPageStart(Context context, String className) {
        long startTime = System.currentTimeMillis();
        Logger.i(TAG, className + "--startTime--" + startTime);

    }

    public static void onPageEnd(Context context, String className) {
        long endTime = System.currentTimeMillis();
        Logger.i(TAG, className + "--endTime--" + endTime);
    }

    /**
     * 检查权限
     *
     * @param permission
     * @return
     */
    public static boolean checkSelfPermission(String permission) {
        if (ContextCompat.checkSelfPermission(mContext, permission) != PackageManager.PERMISSION_GRANTED) {
            return false;
        } else {
            return true;
        }
    }

}
