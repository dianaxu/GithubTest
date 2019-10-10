package com.example.androidtest.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;

import com.example.androidtest.R;
import com.example.androidtest.util.LogUtil;
import com.example.androidtest.util.Util;

import androidx.annotation.Nullable;

/**
 * 1.验证事件传递流程
 * 2.验证cancel事件
 * 3.验证ViewGroup事件拦截
 */
public class TouchActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch);
    }

    /**
     * 事件默认传递流程：
     * TouchActivity: dispatchTouchEvent -> MyTouchViewGroup: dispatchTouchEvent
     * -> MyTouchViewGroup: onInterceptTouchEvent -> MyTouchView: dispatchTouchEvent
     * -> MyTouchView: onTouchEvent -> MyTouchViewGroup: onTouchEvent
     * -> TouchActivity: onTouchEvent
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        LogUtil.i(Util.TOUCHLOG, "TouchActivity: dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        LogUtil.i(Util.TOUCHLOG, "TouchActivity: onTouchEvent");
        return super.onTouchEvent(event);
    }

}
