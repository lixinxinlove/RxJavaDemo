package com.love.rxjavademo.activity;

import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.love.rxjavademo.R;
import com.love.rxjavademo.fragment.FragmentFactory;
import com.love.rxjavademo.fragment.HomeFragment;
import com.love.rxjavademo.fragment.MineFragment;

public class BiLiActivity extends BaseActivity {

    private DrawerLayout mDrawer;
    private FrameLayout flLayout;
    private LinearLayout llContext;

    private Button btnHome;
    private Button btnMine;


    @Override
    protected int getContentViewId() {
        return R.layout.activity_bi_li;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_layout, FragmentFactory.getFragmentByTag(HomeFragment.NAME)).commit();
    }

    @Override
    protected void findView() {
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        flLayout = (FrameLayout) findViewById(R.id.fl_layout);
        llContext = (LinearLayout) findViewById(R.id.ll_context);
        btnHome = (Button) findViewById(R.id.btn_home);
        btnMine = (Button) findViewById(R.id.btn_mine);
    }

    @Override
    protected void setListener() {
        mDrawer.addDrawerListener(new BiLiDrawerListener());
        btnHome.setOnClickListener(this);
        btnMine.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        mDrawer.closeDrawer(GravityCompat.START);
        switch (v.getId()) {
            case R.id.btn_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fl_layout, FragmentFactory.getFragmentByTag(HomeFragment.NAME)).commit();
                break;
            case R.id.btn_mine:
                getSupportFragmentManager().beginTransaction().replace(R.id.fl_layout, FragmentFactory.getFragmentByTag(MineFragment.NAME)).commit();
                break;
            default:
                break;
        }
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
            //WindowManager manager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
            //Display display = manager.getDefaultDisplay();
            //设置右面的布局位置  根据左面菜单的right作为右面布局的left   左面的right+屏幕的宽度（或者right的宽度这里是相等的）为右面布局的right
           // flLayout.layout(llContext.getRight(), 0, llContext.getRight() + display.getWidth(), display.getHeight());
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
