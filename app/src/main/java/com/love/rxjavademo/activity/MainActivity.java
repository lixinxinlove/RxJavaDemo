package com.love.rxjavademo.activity;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.love.rxjavademo.R;
import com.love.rxjavademo.md.MaterialDesignActivity;
import com.love.rxjavademo.rxjava.OkHttpActivity;
import com.love.rxjavademo.rxjava.RetrofitActivity;
import com.love.rxjavademo.rxjava.RxJavaActivity;
import com.love.rxjavademo.rxjava.Test1Activity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.List;

public class MainActivity extends BaseActivity {

    private static final String TAG = "MainActivity";

    private TextView textView;



    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void findView() {
        textView = (TextView) findViewById(R.id.tv);
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, getAdresseMAC(this));
    }


    private static final String marshmallowMacAddress = "02:00:00:00:00:00";
    private static final String fileAddressMac = "/sys/class/net/wlan0/address";


    //获取 手机MAC
    public static String getAdresseMAC(Context context) {
        WifiManager wifiMan = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        WifiInfo wifiInf = wifiMan.getConnectionInfo();

        if (wifiInf != null && marshmallowMacAddress.equals(wifiInf.getMacAddress())) {
            String result = null;
            try {
                result = getAdressMacByInterface();
                if (result != null) {
                    return result;
                } else {
                    result = getAddressMacByFile(wifiMan);
                    return result;
                }
            } catch (IOException e) {
                Log.e("MobileAccess", "Erreur lecture propriete Adresse MAC");
            } catch (Exception e) {
                Log.e("MobileAcces", "Erreur lecture propriete Adresse MAC ");
            }
        } else {
            if (wifiInf != null && wifiInf.getMacAddress() != null) {
                return wifiInf.getMacAddress();
            } else {
                return "";
            }
        }
        return marshmallowMacAddress;
    }

    private static String getAdressMacByInterface() {
        try {
            List<NetworkInterface> all = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface nif : all) {
                if (nif.getName().equalsIgnoreCase("wlan0")) {
                    byte[] macBytes = nif.getHardwareAddress();
                    if (macBytes == null) {
                        return "";
                    }

                    StringBuilder res1 = new StringBuilder();
                    for (byte b : macBytes) {
                        res1.append(String.format("%02X:", b));
                    }

                    if (res1.length() > 0) {
                        res1.deleteCharAt(res1.length() - 1);
                    }
                    return res1.toString();
                }
            }

        } catch (Exception e) {
            Log.e("MobileAcces", "Erreur lecture propriete Adresse MAC ");
        }
        return null;
    }


    private static String getAddressMacByFile(WifiManager wifiMan) throws Exception {
        String ret;
        int wifiState = wifiMan.getWifiState();

        wifiMan.setWifiEnabled(true);
        File fl = new File(fileAddressMac);
        FileInputStream fin = new FileInputStream(fl);
        ret = crunchifyGetStringFromStream(fin);
        fin.close();

        boolean enabled = WifiManager.WIFI_STATE_ENABLED == wifiState;
        wifiMan.setWifiEnabled(enabled);
        return ret;
    }

    private static String crunchifyGetStringFromStream(InputStream crunchifyStream) throws IOException {
        if (crunchifyStream != null) {
            Writer crunchifyWriter = new StringWriter();

            char[] crunchifyBuffer = new char[2048];
            try {
                Reader crunchifyReader = new BufferedReader(new InputStreamReader(crunchifyStream, "UTF-8"));
                int counter;
                while ((counter = crunchifyReader.read(crunchifyBuffer)) != -1) {
                    crunchifyWriter.write(crunchifyBuffer, 0, counter);
                }
            } finally {
                crunchifyStream.close();
            }
            return crunchifyWriter.toString();
        } else {
            return "No Contents";
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
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

    public void directory(View view) {
        startActivity(new Intent(this, DirectoryActivity.class));
    }

    public void permissions(View view) {
        startActivity(new Intent(this, RxPermissionsActivity.class));
    }


    public void expandableListView(View view) {
        startActivity(new Intent(this, ExpandableListViewActivity.class));
    }

    public void shareActivity(View view) {
        startActivity(new Intent(this, ShareActivity.class));
    }

    public void scrollViewActivity(View view) {
        startActivity(new Intent(this, ScrollViewActivity.class));
    }

    public void RxSharedPreferencesActivity(View view) {
        startActivity(new Intent(this, RxSharedPreferencesActivity.class));
    }

    public void ViewStubActivity(View view) {
        startActivity(new Intent(this, ViewStubActivity.class));
    }

    public void SQLiteActivity(View view) {
        startActivity(new Intent(this, SQLiteActivity.class));
    }

    public void MaterialDesignActivity(View view) {
        startActivity(new Intent(this, MaterialDesignActivity.class));
    }

    public void ConstraintLayoutActivity(View view) {
        startActivity(new Intent(this, ConstraintLayoutActivity.class));
    }

    public void LocalBroadcastActivity(View view) {
        startActivity(new Intent(this, LocalBroadcastActivity.class));
    }

    public void RecyclerViewAdapterActivity(View view) {
        startActivity(new Intent(this, RecyclerViewAdapterActivity.class));
    }

    public void ViewSwitcherActivity(View view) {
        startActivity(new Intent(this, ViewSwitcherActivity.class));
    }

    public void OkIoActivity(View view) {
        startActivity(new Intent(this, OkIoActivity.class));
    }

    public void DialogFragmentDemoActivity(View view) {
        startActivity(new Intent(this, DialogFragmentDemoActivity.class));
    }

    public void CacheActivity(View view) {
        startActivity(new Intent(this, CacheActivity.class));
    }

    public void RecyclerViewTopActivity(View view) {
        startActivity(new Intent(this, RecyclerViewTopActivity.class));
    }

}
