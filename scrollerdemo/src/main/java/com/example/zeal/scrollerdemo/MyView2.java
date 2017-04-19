package com.example.zeal.scrollerdemo;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by liaowj on 2017/4/19.
 */

public class MyView2 extends LinearLayout {

    public MyView2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            Log.e("zeal", "MyView2 dispatchTouchEvent ACTION_DOWN");
        } else if (ev.getAction() == MotionEvent.ACTION_MOVE) {
            Log.e("zeal", "MyView2 dispatchTouchEvent ACTION_MOVE");
        } else if (ev.getAction() == MotionEvent.ACTION_UP) {
            Log.e("zeal", "MyView2 dispatchTouchEvent ACTION_UP");
        }
        return super.dispatchTouchEvent(ev);
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {

        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            Log.e("zeal", "MyView2 onInterceptTouchEvent  ACTION_DOWN");
        } else if (ev.getAction() == MotionEvent.ACTION_MOVE) {
            Log.e("zeal", "MyView2 onInterceptTouchEvent  ACTION_MOVE");
        } else if (ev.getAction() == MotionEvent.ACTION_UP) {
            Log.e("zeal", "MyView2 onInterceptTouchEvent  ACTION_UP");
        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {

        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            Log.e("zeal", "MyView2 onTouchEvent ACTION_DOWN");
        } else if (ev.getAction() == MotionEvent.ACTION_MOVE) {
            Log.e("zeal", "MyView2 onTouchEvent ACTION_MOVE");
        } else if (ev.getAction() == MotionEvent.ACTION_UP) {
            Log.e("zeal", "MyView2 onTouchEvent ACTION_UP");
        }
        Log.e("zeal", "MyView2 onTouchEvent---- " + super.onTouchEvent(ev));
        return true;
    }
}
