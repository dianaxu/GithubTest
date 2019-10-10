package com.example.androidtest.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;

import com.example.androidtest.R;
import com.example.androidtest.util.LogUtil;
import com.example.androidtest.util.Util;

import androidx.annotation.Nullable;

/**
 * 2.验证cancel事件
 */
public class TouchCancelActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touchcancel);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        LogUtil.i(Util.TOUCHLOG, "TouchCancelActivity: dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        LogUtil.i(Util.TOUCHLOG, "TouchCancelActivity: onTouchEvent");
        return super.onTouchEvent(event);
    }
}
