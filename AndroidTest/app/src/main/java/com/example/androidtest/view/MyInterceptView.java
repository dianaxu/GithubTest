package com.example.androidtest.view;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.androidtest.util.LogUtil;
import com.example.androidtest.util.Util;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class MyInterceptView extends View {
    public MyInterceptView(Context context) {
        super(context);
    }

    public MyInterceptView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyInterceptView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MyInterceptView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        LogUtil.i(Util.TOUCHLOG, "MyInterceptView: dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        LogUtil.i(Util.TOUCHLOG, "MyInterceptView: onTouchEvent");
        return super.onTouchEvent(ev
        );
    }
}
