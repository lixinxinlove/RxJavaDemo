package com.love.sdk.util;

import android.util.Log;

/**
 * Created by android on 2017/9/27.
 */

public class Logger {

    public static boolean isDebug = true;

    public static void i(String tag, String str) {
        if (isDebug) {
            Log.i(tag, str);
        }
    }

    public static void d(String tag, String str) {
        if (isDebug) {
            Log.d(tag, str);
        }
    }

    public static void e(String tag, String str) {
        if (isDebug) {
            Log.e(tag, str);
        }
    }

}
