package com.love.rxjavademo.activity;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.love.rxjavademo.R;

public class PackageInfoActivity extends AppCompatActivity {


    private TextView tv1;
    private TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_info);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);

        PackageManager pm = getPackageManager();
        try {
            PackageInfo pi = pm.getPackageInfo(getPackageName(), 0);
            tv1.setText(pi.versionName);
            tv2.setText(pi.versionCode+"");
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}
