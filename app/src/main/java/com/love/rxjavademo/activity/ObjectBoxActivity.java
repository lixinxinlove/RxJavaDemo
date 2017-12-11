package com.love.rxjavademo.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.love.rxjavademo.App;
import com.love.rxjavademo.R;
import com.love.rxjavademo.bean.Food;

import java.util.List;

import io.objectbox.Box;

public class ObjectBoxActivity extends BaseActivity {

    private TextView textView;
    private Food food;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_object_box;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        food = new Food("name", 10, 12.00, true, "A", "Box");
    }

    @Override
    protected void findView() {
        textView = (TextView) findViewById(R.id.tv);
    }

    @Override
    protected void setListener() {
    }


    public void onSave(View view) {
        Box<Food> foodBox = App.getBoxStore().boxFor(Food.class);
        food.setId(1);
        foodBox.put(food);
    }

    public void onSelect(View view) {
        Box<Food> foodBox = App.getBoxStore().boxFor(Food.class);
        List<Food> foodList = foodBox.query().build().find();
        if (foodList != null) {
            textView.setText(foodList.get(0).toString());
        } else {
            textView.setText("没有数据");
        }
    }

}
