package com.love.rxjavademo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.love.rxjavademo.R;
import com.love.rxjavademo.rxjava.OkHttpActivity;
import com.love.rxjavademo.rxjava.RetrofitActivity;
import com.love.rxjavademo.rxjava.RxJavaActivity;
import com.love.rxjavademo.rxjava.Test1Activity;
import com.love.sdk.EventeCount;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        NetworkInterface networkInterface = null;
//        try {
//            networkInterface = NetworkInterface.getByName("wlan0");
//        } catch (SocketException e) {
//            e.printStackTrace();
//        }
//        try {
//            String mac = null;
//
//            for(int i=0;i<networkInterface.getHardwareAddress().length;i++){
//                Log.e("mac",networkInterface.getHardwareAddress()[i]+"");
//            }
//
//            mac = new String(networkInterface.getHardwareAddress());
//            Log.e("MAC", mac);
//        } catch (SocketException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        EventeCount.onPageStart(this, this.getLocalClassName());
    }

    @Override
    protected void onPause() {
        super.onPause();
        EventeCount.onPageEnd(this, this.getLocalClassName());
    }


    public void test1(View view) {
        startActivity(new Intent(this, Test1Activity.class));
    }

    public void okHttp(View view) {
        startActivity(new Intent(this, OkHttpActivity.class));
    }

    public void retrofit(View view) {
        startActivity(new Intent(this, RetrofitActivity.class));
    }

    public void rxBus(View view) {
        startActivity(new Intent(this, RxJavaActivity.class));
    }

    public void put(View view) {
        startActivity(new Intent(this, RecyclerViewActivity.class));
    }

    public void glide(View view) {
        startActivity(new Intent(this, GlideActivity.class));
    }

    public void animator(View view) {
        startActivity(new Intent(this, AnimatorActivity.class));
    }

    public void notification(View view) {
        startActivity(new Intent(this, NotificationActivity.class));
    }

    public void ViewPager(View view) {
        startActivity(new Intent(this, ViewPagerActivity.class));
    }
  public void packageInfo(View view) {
        startActivity(new Intent(this, PackageInfoActivity.class));
    }


}
