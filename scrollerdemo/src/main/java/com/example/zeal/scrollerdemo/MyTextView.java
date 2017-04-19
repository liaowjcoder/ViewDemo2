package com.example.zeal.scrollerdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;

/**
 * Created by liaowj on 2017/4/19.
 */

public class MyTextView extends android.support.v7.widget.AppCompatTextView {
    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            Log.e("zeal", "MyTextView dispatchTouchEvent ACTION_DOWN");
        } else if (ev.getAction() == MotionEvent.ACTION_MOVE) {
            Log.e("zeal", "MyTextView dispatchTouchEvent ACTION_MOVE");
        } else if (ev.getAction() == MotionEvent.ACTION_UP) {
            Log.e("zeal", "MyTextView dispatchTouchEvent ACTION_UP");
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {

        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            Log.e("zeal", "MyTextView onTouchEvent ACTION_DOWN");
        } else if (ev.getAction() == MotionEvent.ACTION_MOVE) {
            Log.e("zeal", "MyTextView onTouchEvent ACTION_MOVE");
        } else if (ev.getAction() == MotionEvent.ACTION_UP) {
            Log.e("zeal", "MyTextView onTouchEvent ACTION_UP");
        }
        Log.e("zeal", "MyTextView onTouchEvent----" +super.onTouchEvent(ev));
        return super.onTouchEvent(ev);
    }
}
