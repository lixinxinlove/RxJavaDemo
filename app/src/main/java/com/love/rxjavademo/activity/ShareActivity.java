package com.love.rxjavademo.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.love.rxjavademo.R;

import java.io.File;
import java.util.ArrayList;

public class ShareActivity extends BaseActivity {

    @Override
    protected int getContentViewId() {
        return R.layout.activity_share;
    }

    @Override
    protected void findView() {

    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    public void shareText(View view) {
        Intent intent1 = new Intent(Intent.ACTION_SEND);
        intent1.putExtra(Intent.EXTRA_TEXT, "This is my text to send");
        intent1.setType("text/plain");
        startActivity(Intent.createChooser(intent1, "share"));
    }


    public void shareImage(View view) {
        Intent intent2 = new Intent(Intent.ACTION_SEND);
        Uri uri = Uri.fromFile(new File("/storage/emulated/0/pictures/1474533294366.jpg"));
        intent2.putExtra(Intent.EXTRA_STREAM, uri);
        intent2.setType("image/*");
        startActivity(Intent.createChooser(intent2, "share"));
    }

    public void shareTextAndImage(View view) {
        ArrayList<Uri> imageUris = new ArrayList<Uri>();
        Uri imageUri1 = Uri.fromFile(new File("/storage/emulated/0/pictures/1474533294366.jpg"));
        Uri imageUri2 = Uri.fromFile(new File("/storage/emulated/0/UCDownloads/pictures/319534.jpg"));
        imageUris.add(imageUri1);
        imageUris.add(imageUri2);

        Intent intent3 = new Intent();
        intent3.setAction(Intent.ACTION_SEND_MULTIPLE);
        intent3.putParcelableArrayListExtra(Intent.EXTRA_STREAM, imageUris);
        intent3.setType("image/*");
        startActivity(Intent.createChooser(intent3, "share"));
    }


}
