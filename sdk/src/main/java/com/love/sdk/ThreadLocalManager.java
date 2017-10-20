package com.love.sdk;

import android.app.Activity;

/**
 * Created by android on 2017/10/20.
 */

public class ThreadLocalManager {
    public static ThreadLocal<Activity> tl = new ThreadLocal<>();
}
