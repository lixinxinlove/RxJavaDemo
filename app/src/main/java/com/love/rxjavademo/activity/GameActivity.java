package com.love.rxjavademo.activity;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.love.rxjavademo.R;

import java.util.Random;

public class GameActivity extends BaseActivity {


    private ImageView imgs[];

    private Button btnStart;

    private MyHandler mHandler;

    private int sum = 0;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_game;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHandler = new MyHandler();
        for (int i = 0; i < imgs.length; i++) {
            imgs[i].setEnabled(false);
        }
    }

    @Override
    protected void findView() {
        Resources res = getResources();
        imgs = new ImageView[8];
        for (int i = 0; i < 8; i++) {
            String imgName = "iv" + (i + 1);
            int imgId = res.getIdentifier(imgName, "id", getPackageName());
            imgs[i] = (ImageView) findViewById(imgId);
        }
        btnStart = (Button) findViewById(R.id.btn_start);
    }

    @Override
    protected void setListener() {
        btnStart.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.btn_start:
                startGame();
                break;
            default:
                break;
        }
    }

    private void startGame() {
        if (mHandler.hasMessages(100)) {
            //表示该队列含有该消息，说明已经启动
            Toast.makeText(GameActivity.this, "游戏已经启动", Toast.LENGTH_SHORT).show();
            return;
        }
        //让Handler玩起来
        Message msg = Message.obtain();
        msg.what = 100;
        msg.arg1 = 0;
        mHandler.sendMessage(msg);
        //生成一个随机数:5~10秒之间
        Random rd = new Random();
        int time = rd.nextInt(8) + 5;
        //延时发送停止消失
        Message msg_stop = Message.obtain();
        msg_stop.what = 200;
        mHandler.sendMessageDelayed(msg_stop, time * 1000);
    }

    int valuse;

    private void showBg(int position) {
        valuse = position;
        for (int i = 0; i < imgs.length; i++) {
            if (i == position) {
                imgs[i].setEnabled(true);
            } else {
                //其他的，背景都去掉
                imgs[i].setEnabled(false);
            }
        }
    }


    class MyHandler extends Handler {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 100: {
                    //表示显示下一个图片的背景
                    //取出当前显示背景图片的位置
                    int current = msg.arg1;
                    //++
                    current++;
                    //再创建一个Message,设置其arg1
                    Message msgNew = Message.obtain();
                    //标识
                    msgNew.what = 100;
                    //参数
                    msgNew.arg1 = current;
                    //延时发送
                    mHandler.sendMessageDelayed(msgNew, current * 10);
                    //切换显示图片背景
                    showBg(current % imgs.length);
                }
                break;
                case 200: {
                    //收到停止的消息
                    //移除msg.what=100的所有消息
                    mHandler.removeMessages(100);
                    //读取最终结果
                    Toast.makeText(GameActivity.this, "恭喜你中奖了" + valuse, Toast.LENGTH_SHORT).show();
                }
                break;
            }
        }
    }
}
