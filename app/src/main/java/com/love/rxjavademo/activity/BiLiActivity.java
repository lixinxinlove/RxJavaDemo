package com.love.rxjavademo.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.love.rxjavademo.R;

public class BiLiActivity extends BaseActivity {

    private DrawerLayout mDrawer;
    private FrameLayout flLayout;
    private LinearLayout llContext;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_bi_li;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void findView() {
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        flLayout = (FrameLayout) findViewById(R.id.fl_layout);
        llContext = (LinearLayout) findViewById(R.id.ll_context);
    }

    @Override
    protected void setListener() {
        mDrawer.addDrawerListener(new BiLiDrawerListener());
    }

    @Override
    public void onBackPressed() {

        if (mDrawer.isDrawerOpen(GravityCompat.START)) {
            mDrawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private class BiLiDrawerListener implements DrawerLayout.DrawerListener {

        @Override
        public void onDrawerSlide(View drawerView, float slideOffset) {
            WindowManager manager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
            Display display = manager.getDefaultDisplay();
            //设置右面的布局位置  根据左面菜单的right作为右面布局的left   左面的right+屏幕的宽度（或者right的宽度这里是相等的）为右面布局的right
            flLayout.layout(llContext.getRight(), 0, llContext.getRight() + display.getWidth(), display.getHeight());
        }

        @Override
        public void onDrawerOpened(View drawerView) {

        }

        @Override
        public void onDrawerClosed(View drawerView) {

        }

        @Override
        public void onDrawerStateChanged(int newState) {

        }
    }
}
