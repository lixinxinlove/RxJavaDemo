package com.love.sdk.util;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

import com.love.sdk.activity.BaseActivity;

/**
 * Created by android on 2017/10/20.
 */

public class DeviceUtil {

    private static boolean grant;

    @SuppressLint("HardwareIds")
    public static String getDeviceId(final Context context) {


//        Toast.makeText(context, "sdk", Toast.LENGTH_LONG).show();
        Log.e("sdk","sdk");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {

                BaseActivity baseActivity=new BaseActivity();
              //  BaseActivity activity = (BaseActivity) ThreadLocalManager.tl.get();
                baseActivity.setRequestPermissionListener(new BaseActivity.RequestPermissionListener() {
                    @Override
                    public void onRequestPermissionListener(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
                        grant = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                        if (grant) {
                            Toast.makeText(context, "权限请求成功", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                ActivityCompat.requestPermissions(baseActivity, new String[]{Manifest.permission.READ_PHONE_STATE}, 0);
            } else {
                grant = true;
            }
        } else {
            grant = true;
        }
        if (grant) {
            TelephonyManager manager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            return manager.getDeviceId();
        }
        return "";
    }

}
