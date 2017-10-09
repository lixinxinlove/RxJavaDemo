package com.love.rxjavademo.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.love.rxjavademo.R;

public class DirectoryActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directory);


        StorageManager mStorageManager = (StorageManager) getSystemService(Context.STORAGE_SERVICE);
        StorageVolume primaryStorageVolume = mStorageManager.getPrimaryStorageVolume();
        Intent intent = primaryStorageVolume.createAccessIntent(Environment.DIRECTORY_DOWNLOADS);
        startActivityForResult(intent, 100);
    }


    @Override
    public void onActivityReenter(int resultCode, Intent data) {
        super.onActivityReenter(resultCode, data);
        if (resultCode == 100) {
            Toast.makeText(DirectoryActivity.this, "用户操作了", Toast.LENGTH_LONG).show();
            Log.e("DirectoryActivity","用户操作了");
        }
    }
}
