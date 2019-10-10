package com.example.androidtest.view;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

import com.example.androidtest.util.LogUtil;
import com.example.androidtest.util.Util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class MyInterceptViewGroup extends FrameLayout {
    public MyInterceptViewGroup(@NonNull Context context) {
        super(context);
    }

    public MyInterceptViewGroup(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyInterceptViewGroup(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MyInterceptViewGroup(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        LogUtil.i(Util.TOUCHLOG, "MyInterceptViewGroup: dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        super.onInterceptTouchEvent(ev);
        LogUtil.i(Util.TOUCHLOG, "MyInterceptViewGroup: onInterceptTouchEvent");
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                LogUtil.i(Util.TOUCHLOG, "MyInterceptViewGroup: 手指按下");
                break;
            case MotionEvent.ACTION_MOVE:
                LogUtil.i(Util.TOUCHLOG, "MyInterceptViewGroup: 手指移动");
                break;
            case MotionEvent.ACTION_UP:
                LogUtil.i(Util.TOUCHLOG, "MyInterceptViewGroup: 手指离开");
                break;
            default:
                break;
        }
        return true;
    }
}
