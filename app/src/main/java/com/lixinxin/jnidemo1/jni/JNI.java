package com.lixinxin.jnidemo1.jni;

/**
 * Created by android on 2017/12/1.
 */

public class JNI {

    static {
        System.loadLibrary("Hello");
    }

    public native String getNameFromJni();

    public native int add(int x, int y);

    public native String connect(String str);

}
