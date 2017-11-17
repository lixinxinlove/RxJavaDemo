package com.love.rxjavademo.activity;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.love.rxjavademo.R;

public class AnimatorActivity extends BaseActivity {


    private ImageView imageView;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_animator;
    }

    @Override
    protected void findView() {
        imageView = (ImageView) findViewById(R.id.image);
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public void btn1(View view) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(imageView, "alpha", 1f, 0, 1f);
        animator.setDuration(5000);
        animator.start();
    }

    public void btn2(View view) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(imageView, "rotationY", 0, 180);
        animator.setDuration(5000);
        animator.start();
    }

    public void btn3(View view) {
        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.animator_demo1);
        animator.setTarget(imageView);
        animator.start();
    }


    public void btn4(View view) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(imageView, "rotationY", 0, 180);
        animator.setDuration(2000);
        animator.start();
    }

}