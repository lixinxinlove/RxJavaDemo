package com.love.rxjavademo.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.love.rxjavademo.R;

public class ViewPagerActivity extends BaseActivity {

    private ViewPager mViewPager;
    private RelativeLayout relativeLayout;

    private MyAdapter adapter;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_view_pager;
    }

    @Override
    protected void findView() {
        adapter = new MyAdapter();
        mViewPager = (ViewPager) findViewById(R.id.view_pager);

        mViewPager.setOverScrollMode(View.OVER_SCROLL_NEVER);
        initViewPager();
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    private void initViewPager() {
        WindowManager wm = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        int screenWidth = wm.getDefaultDisplay().getWidth();
        int screenHeight = wm.getDefaultDisplay().getHeight();
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(screenWidth * 6 / 10, screenHeight * 6 / 10);
        mViewPager.setLayoutParams(params);
        mViewPager.setAdapter(adapter);
        relativeLayout = (RelativeLayout) findViewById(R.id.relativelayout);
        mViewPager.setOffscreenPageLimit(2);
        mViewPager.setPageMargin(30);
        mViewPager.setClipChildren(false); //用来定义他的子控件是否要在他应有的边界内进行绘制
        mViewPager.setPageTransformer(false, new ZoomOutPageTransformer());
        //  mViewPager.setCurrentItem(mPosition);
        relativeLayout.setClipChildren(false);
    }

    //设置切换动画
    public class ZoomOutPageTransformer implements ViewPager.PageTransformer {
        private static final float MAX_SCALE = 1.0f;
        private static final float MIN_SCALE = 0.85f;//0.85f

        @Override
        public void transformPage(View page, float position) {
            if (position <= 1) {
                float scaleFactor = MIN_SCALE + (1 - Math.abs(position)) * (MAX_SCALE - MIN_SCALE);
                page.setScaleX(scaleFactor);
                if (position > 0) {
                    page.setTranslationX(-scaleFactor * 2);
                } else if (position < 0) {
                    page.setTranslationX(scaleFactor * 2);
                }
                page.setScaleY(scaleFactor);
            } else {
                page.setScaleX(MIN_SCALE);
                page.setScaleY(MIN_SCALE);
            }
        }
    }


    private class MyAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return 10;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup view, int position, Object object) {
            view.removeView((View) object);
        }

        @Override
        public View instantiateItem(ViewGroup view, int position) {
            View itemView = View.inflate(ViewPagerActivity.this, R.layout.item_pager_view, null);
            view.addView(itemView);
            return itemView;
        }
    }
}
