package com.example.zeal.scrollerdemo.ex_inner;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;

/**
 * Created by liaowj on 2017/4/21.
 */

public class ListViewEx extends ListView {

    private int mLastX;
    private int mLastY;
    private HorizontalScrollViewEx mHorizontalScrollViewEx;
    public ListViewEx(Context context) {
        super(context);
    }

    public ListViewEx(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setHorizontalScrollViewEx2(
            HorizontalScrollViewEx horizontalScrollViewEx) {
         mHorizontalScrollViewEx = horizontalScrollViewEx;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        int x = (int) ev.getX();
        int y = (int) ev.getY();

        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mHorizontalScrollViewEx.requestDisallowInterceptTouchEvent(true);
                break;
            case MotionEvent.ACTION_MOVE:

                int deltaX = x - mLastX;
                int deltaY = y - mLastY;

                if (Math.abs(deltaX) > Math.abs(deltaY)) {
                    mHorizontalScrollViewEx.requestDisallowInterceptTouchEvent(false);
                }


                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        mLastY = y;
        mLastX = x;
        return super.dispatchTouchEvent(ev);
    }
}
