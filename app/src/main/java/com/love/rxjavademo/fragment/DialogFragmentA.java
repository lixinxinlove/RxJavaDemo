package com.love.rxjavademo.fragment;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.love.rxjavademo.R;

/**
 * Created by android on 2017/11/22.
 */

public class DialogFragmentA extends DialogFragment implements View.OnClickListener {

    private View view;
    private Button btnClose;

    @Override
    public void onStart() {
        super.onStart();
        Window window = getDialog().getWindow();
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        WindowManager.LayoutParams windowParams = window.getAttributes();
        windowParams.dimAmount = 0.5f;
        windowParams.windowAnimations = R.style.dialogAnim;  //dialog 弹出的动画
        //windowParams.y = 100;  //距离顶部100
        windowParams.gravity = Gravity.BOTTOM;  //底部
        window.setAttributes(windowParams);
        Dialog dialog = getDialog();
        if (dialog != null) {
            DisplayMetrics dm = new DisplayMetrics();
            getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
            // dialog.getWindow().setLayout((int) (dm.widthPixels * 1.0), (int) (dm.heightPixels * 0.5)); //设置 dialog 的宽高
            dialog.getWindow().setLayout((int) (dm.widthPixels * 1.0), ViewGroup.LayoutParams.WRAP_CONTENT);
        }
        dialog.setCanceledOnTouchOutside(false);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return super.onCreateDialog(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);  //去掉标题

        view = inflater.inflate(R.layout.dialog_fragment_a, null);
        findView();
        setListener();
        return view;
    }

    private void findView() {
        btnClose = (Button) view.findViewById(R.id.btn_close);
    }

    private void setListener() {
        btnClose.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_close:
                this.dismiss();
                break;
            default:
                break;
        }
    }
}
