package com.example.zeal.scrollerdemo;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.nineoldandroids.view.ViewHelper;


/**
 * Created by liaowj on 2017/4/14.
 */

public class MyView extends android.support.v7.widget.AppCompatImageView implements View.OnTouchListener {

    private int mLastX;
    private int mLastY;

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOnTouchListener(this);
    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int x = (int) event.getRawX();
        int y = (int) event.getRawY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:

                //获得手指滑动的间距
                int deltaX = (int) (x - mLastX);
                int deltaY = (int) (y - mLastY);
                //兼容
                //ViewHelper.setTranslationX(this, this.getTranslationX() + deltaX);
                //ViewHelper.setTranslationY(this, this.getTranslationY() + deltaY);
                this.setTranslationX( this.getTranslationX() + deltaX);
                this.setTranslationY( this.getTranslationY() + deltaY);
                break;

            case MotionEvent.ACTION_UP:
                break;
        }

        mLastX = x;
        mLastY = y;

        return true;
    }
}
