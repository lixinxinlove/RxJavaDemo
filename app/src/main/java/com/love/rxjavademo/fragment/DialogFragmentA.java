package com.love.rxjavademo.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.love.rxjavademo.R;
import com.love.rxjavademo.fragment.base.BaseDialogFragment;

/**
 * Created by android on 2017/11/22.
 */

public class DialogFragmentA extends BaseDialogFragment implements View.OnClickListener, DialogInterface.OnKeyListener {

    private Button btnClose;
    private EditText editText;

    @Override
    public void onStart() {
        super.onStart();
        Window window = getDialog().getWindow();
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        WindowManager.LayoutParams windowParams = window.getAttributes();
        windowParams.dimAmount = 0.5f;   //背景 透明度
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
        dialog.setOnKeyListener(this);
        dialog.setOnDismissListener(this);
    }


    protected void findView() {
        btnClose = (Button) rootView.findViewById(R.id.btn_close);
        editText = (EditText) rootView.findViewById(R.id.edit_name);
    }

    @Override
    protected int getResId() {
        return R.layout.dialog_fragment_a;
    }

    protected void setListener() {
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

    @Override
    public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Toast.makeText(getContext(), "返回建", Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        Toast.makeText(getContext(), "onDismiss", Toast.LENGTH_SHORT).show();
    }

    /**
     * 弹出软键盘  需要延时调用
     */
    public void showKeyboard() {
        if (editText != null) {
            //设置可获得焦点
            editText.setFocusable(true);
            editText.setFocusableInTouchMode(true);
            //请求获得焦点
            editText.requestFocus();
            //调用系统输入法
            InputMethodManager inputManager = (InputMethodManager) editText
                    .getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            inputManager.showSoftInput(editText, 0);
        }
    }
}
