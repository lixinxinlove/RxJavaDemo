package com.lixinxin.leeview.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;

import com.lixinxin.leeview.R;

/**
 * Created by android on 2017/12/13.
 */

public class LeeDialog extends Dialog {

    public LeeDialog(@NonNull Context context) {
        this(context, 0);
    }

    public LeeDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, R.style.alert_dialog);
    }

    protected LeeDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_demo);
    }
}
