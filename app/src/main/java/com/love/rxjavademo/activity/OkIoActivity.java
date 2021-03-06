package com.love.rxjavademo.activity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Toast;

import com.love.rxjavademo.R;
import com.love.rxjavademo.util.OkHttpUtils;
import com.love.rxjavademo.util.Time2Utils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okio.BufferedSink;
import okio.Okio;
import okio.Source;

public class OkIoActivity extends BaseActivity {

    private String imageUrl = "http://7xi8d6.com1.z0.glb.clouddn.com/20171025112955_lmesMu_katyteiko_25_10_2017_11_29_43_270.jpeg";

    @Override
    protected int getContentViewId() {
        return R.layout.activity_ok_io;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    protected void findView() {

    }

    @Override
    protected void setListener() {

    }


    public void okHttp(View view) {
      //  OkHttpUtils.getInstance().get(imageUrl, callback);

        Map<String, String> map = new HashMap<>();
        map.put("key", "lixinxin");
        map.put("key1", "lixinxin");
        map.put("key2", "lixinxin");
        map.put("key3", "lixinxin");

        OkHttpUtils.getInstance().post(imageUrl, map, callback);
    }

    private Callback callback = new Callback() {
        @Override
        public void onFailure(Call call, IOException e) {

        }

        @Override
        public void onResponse(Call call, Response response) throws IOException {
            String filePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + Time2Utils.getToday() + "lee.jpeg";
            File file = new File(filePath);
            BufferedSink sink = Okio.buffer(Okio.sink(file));
            Source source = response.body().source();
            sink.writeAll(source);
            sink.flush();

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(OkIoActivity.this, "下载成功", Toast.LENGTH_SHORT).show();
                }
            });
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //取消没有完成的请求
        OkHttpUtils.getInstance().cancel();
    }
}
