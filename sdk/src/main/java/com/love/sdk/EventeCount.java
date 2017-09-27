package com.love.sdk;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;

import com.love.sdk.util.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import static java.lang.System.currentTimeMillis;

/**
 * Created by android on 2017/9/27.
 */

public class EventeCount {


    private final static String TAG = "EventeCount";

    private static Context mContext;

    private EventeCount() {
    }

    public static void init(Context context) {
        mContext = context;

        new Thread(new Runnable() {
            @Override
            public void run() {
                printDeviceInfo();
            }
        }).start();
    }

    public static void setDebugMode(boolean isDebug) {
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
    public static String getNetworkOperatorName() {
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

    //IMSI
    public static String getSubscriberId() {
        TelephonyManager tm = (TelephonyManager) mContext.getSystemService(Context.TELEPHONY_SERVICE);
        if (tm == null) {
            return "";
        }
        return "" + tm.getSubscriberId();
    }

    //sim卡所在国家
    public static String getNetworkCountryIso() {
        TelephonyManager tm = (TelephonyManager) mContext.getSystemService(Context.TELEPHONY_SERVICE);
        if (tm == null) {
            return "";
        }
        return "" + tm.getNetworkCountryIso();
    }

    //运营商编号。
    public static String getNetworkOperator() {
        TelephonyManager tm = (TelephonyManager) mContext.getSystemService(Context.TELEPHONY_SERVICE);
        if (tm == null) {
            return "";
        }
        return tm.getNetworkOperator();
    }

    //android 获取当前手机型号
    public static String getPhoneModel() {
        Build bd = new Build();
        return bd.MODEL;
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

    //android获取当前时区
    public static String getTimeZone() {
        TimeZone tz = TimeZone.getDefault();
        String s = tz.getID();
        System.out.println(s);
        return s;
    }

    //android获取当前日期时间
    public static String getDateAndTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date curDate = new Date(currentTimeMillis());//获取当前时间
        String str = formatter.format(curDate);
        return str;
    }

    //获取手机系统语言 0中文简体 1其它
    public static String getLanguage() {
        Locale locale = mContext.getResources().getConfiguration().locale;
        String language = locale.getLanguage();
        if (language.endsWith("zh"))
            return "0";
        else
            return "1";
    }

    public static void onPageStart(Context context, String className) {
        long startTime = System.currentTimeMillis();
        Logger.i(TAG, className);
        Logger.i(TAG, startTime + "");
    }

    public static void onPageEnd(Context context, String className) {
        long endTime = System.currentTimeMillis();
        Logger.i(TAG, className);
        Logger.i(TAG, endTime + "");
    }

}
