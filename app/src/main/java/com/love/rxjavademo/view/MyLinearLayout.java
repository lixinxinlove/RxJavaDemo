package com.love.rxjavademo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by android on 2017/9/30.
 */

public class MyLinearLayout extends ViewGroup {


    private int viewGroupWidth;

    public MyLinearLayout(Context context) {
        super(context);
    }

    public MyLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        measureChildren(widthMeasureSpec, heightMeasureSpec);
        measureChildren(widthMeasureSpec, heightMeasureSpec);
        viewGroupWidth=getMeasuredWidth();
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int w = 0;
        int h = 0;
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            final View child = getChildAt(i);
            final int childWidth = child.getMeasuredWidth();
            final int childHeight = child.getMeasuredHeight();

            Log.e("lee", childWidth + "");
            Log.e("lee", childHeight + "");

            w += childWidth;
            h += childHeight;

            if (i%2==0){
                child.layout(0, h - childHeight, childWidth, h);
            }else {
                child.layout(viewGroupWidth-childWidth, h - childHeight, viewGroupWidth, h);
            }

        }
    }
}
