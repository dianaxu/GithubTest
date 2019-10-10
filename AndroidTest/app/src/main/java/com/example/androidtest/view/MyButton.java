package com.example.androidtest.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.example.androidtest.util.LogUtil;
import com.example.androidtest.util.Util;

import androidx.appcompat.widget.AppCompatButton;

public class MyButton extends AppCompatButton {

    public MyButton(Context context) {
        super(context);
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        LogUtil.i(Util.TOUCHLOG, "MyButton: dispatchTouchEvent  " + ev.getAction());
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        LogUtil.i(Util.TOUCHLOG, "MyButton: onTouchEvent  " + ev.getAction());
        return super.onTouchEvent(ev);
    }
}
