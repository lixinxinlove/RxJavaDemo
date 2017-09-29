package com.love.sdk;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;

import com.love.sdk.activity.PermissionActivity;
import com.love.sdk.util.Logger;

/**
 * Created by android on 2017/9/27.
 */

public class EventeCount {

    private static final int MY_requestCode = 100;

    private final static String TAG = "EventeCount";
    private static Context mContext;
    private static Handler handler = new Handler();

    private EventeCount() {
    }

//    private static EventeCount eventeCount = new EventeCount();
//
//    public static EventeCount getInstance(Context context) {
//        mContext = context;
//        return eventeCount;
//    }

    public static void init(final Context context) {
        mContext = context;

        new Thread(new Runnable() {
            @Override
            public void run() {
                printDeviceInfo();
            }
        }).start();


        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (checkSelfPermission(Manifest.permission.READ_PHONE_STATE)) {
                    printDeviceInfo2();
                } else {
                    //  permissionRequestActivity.requestPermission(new String[]{Manifest.permission.READ_PHONE_STATE}, 100);
                    // PermissionHelper.requestPermissions(PermissionActivity.activity, new String[]{Manifest.permission.READ_PHONE_STATE}, 100, "title", "text", 1);

                    Intent permIntent = new Intent(context, PermissionActivity.class);
                    permIntent.putExtra(Const.KEY_PERMISSIONS, new String[]{Manifest.permission.READ_PHONE_STATE});
                    permIntent.putExtra(Const.KEY_REQUEST_CODE, 100);
                    permIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(permIntent);
                    //ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.READ_PHONE_STATE}, 100);
                }
            }
        }, 5000);


    }

    public void setDebugMode(boolean isDebug) {
        Logger.isDebug = isDebug;
    }

    private static void printDeviceInfo() {
        //  Log.i(TAG, "手机号：" + getLine1Number());
        //  Log.i(TAG, "deviceId：" + getDeviceId());
        Log.i(TAG, "运营商名称：" + getNetworkOperatorName());
        //  Log.i(TAG, "sim卡序列号：" + getSimSerialNumber());
        Log.i(TAG, "获取当前手机品牌：" + getPhoneProduct());
        Log.i(TAG, "获取屏幕分辩率：" + getMetrics());
    }

    private static void printDeviceInfo2() {
        Log.i(TAG, "手机号：" + getLine1Number());
        Log.i(TAG, "deviceId：" + getDeviceId());
        Log.i(TAG, "运营商名称：" + getNetworkOperatorName());
        Log.i(TAG, "sim卡序列号：" + getSimSerialNumber());
        Log.i(TAG, "获取当前手机品牌：" + getPhoneProduct());
        Log.i(TAG, "获取屏幕分辩率：" + getMetrics());
    }


    //手机号码
    public static String getLine1Number() {
        TelephonyManager tm = (TelephonyManager) mContext.getSystemService(Context.TELEPHONY_SERVICE);
        if (tm == null) {
            return "";
        }
        return "" + tm.getLine1Number();
    }

    //deviceId
    public static String getDeviceId() {
        TelephonyManager tm = (TelephonyManager) mContext.getSystemService(Context.TELEPHONY_SERVICE);
        if (tm == null) {
            return "";
        }
        return "" + tm.getDeviceId();
    }

    //运营商名称
    public static String  getNetworkOperatorName() {
        TelephonyManager tm = (TelephonyManager) mContext.getSystemService(Context.TELEPHONY_SERVICE);
        if (tm == null) {
            return "";
        }
        return "" + tm.getNetworkOperatorName();
    }

    //sim卡序列号
    public static String getSimSerialNumber() {
        TelephonyManager tm = (TelephonyManager) mContext.getSystemService(Context.TELEPHONY_SERVICE);
        if (tm == null) {
            return "";
        }
        return "" + tm.getSimSerialNumber();
    }

    //android 获取当前手机品牌
    public static String getPhoneProduct() {
        Build bd = new Build();
        return bd.PRODUCT;
    }

    //android 获取屏幕分辩率
    public static String getMetrics() {
        DisplayMetrics dm = new DisplayMetrics();
        int h = dm.heightPixels;
        int w = dm.widthPixels;
        return h + "*" + w;
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
