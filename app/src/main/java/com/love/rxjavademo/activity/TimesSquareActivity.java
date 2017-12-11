package com.love.rxjavademo.activity;

import android.os.Bundle;

import com.love.rxjavademo.R;
import com.squareup.timessquare.CalendarPickerView;

import java.util.Calendar;
import java.util.Date;


public class TimesSquareActivity extends BaseActivity {


    private CalendarPickerView mCalendarPickerView;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_times_square;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Calendar nextYear = Calendar.getInstance();
        nextYear.add(Calendar.MONTH, 3);


        Date today = new Date();
        mCalendarPickerView.init(today, nextYear.getTime()).withSelectedDate(today);
        mCalendarPickerView.init(today, nextYear.getTime()).inMode(CalendarPickerView.SelectionMode.SINGLE);
    }

    @Override
    protected void findView() {
        mCalendarPickerView= (CalendarPickerView) findViewById(R.id.calendar_view);
    }

    @Override
    protected void setListener() {

    }
}
