package com.love.rxjavademo.rxjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.love.rxjavademo.R;
import com.love.rxjavademo.bean.Girl;
import com.love.rxjavademo.rxbus.RxBus;

import io.reactivex.functions.Consumer;

public class RxJavaActivity extends AppCompatActivity {


    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java);
        textView = (TextView) findViewById(R.id.tv);
        textView.setText("");

        RxBus.getInstance().register(Girl.class).subscribe(new Consumer<Girl>() {
            @Override
            public void accept(Girl girl) throws Exception {
                textView.setText(textView.getText() + girl.get_id());
            }
        });
    }

    public void post(View v) {
        Girl girl = new Girl();
        girl.set_id("100");
        RxBus.getInstance().post(girl);
    }

}
