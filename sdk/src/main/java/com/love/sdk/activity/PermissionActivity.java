package com.love.sdk.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;

import com.love.sdk.Const;

public class PermissionActivity extends AppCompatActivity {

    private String[] permissions;
    private int requestCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);
        permissions = this.getIntent().getStringArrayExtra(Const.KEY_PERMISSIONS);
        requestCode = this.getIntent().getIntExtra(Const.KEY_REQUEST_CODE, 0);
    }

    @Override
    protected void onStart() {
        super.onStart();
        ActivityCompat.requestPermissions(this, permissions, requestCode);
        finish();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

    }
}
