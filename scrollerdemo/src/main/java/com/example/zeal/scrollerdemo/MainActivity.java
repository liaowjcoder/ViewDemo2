package com.example.zeal.scrollerdemo;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Scroller;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ImageView mIv;
    private ImageView mMyView;

    private Scroller mScroller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mIv = (ImageView) findViewById(R.id.imageview);
        mMyView = (ImageView) findViewById(R.id.MyView);
        demo1();
    }

    private void demo1() {
        mScroller = new Scroller(this);

        mIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //在已有的位置上，往左上角移动10个像素
                //mIv.scrollBy(10, 10);
                Log.e("zeal", mIv.getScrollX() + ";" + mIv.getScrollY());
                mIv.scrollTo(60, 70);
                Log.e("zeal", mIv.getScrollX() + ";" + mIv.getScrollY());
                mIv.scrollTo(-50, -50);

                Log.e("zeal", mIv.getScrollX() + ";" + mIv.getScrollY());
            }
        });

    }

    /**
     * view 随手指在整个屏幕滑动
     */
    private void demo2() {

    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            Log.e("zeal", "MainActivity onTouchEvent ACTION_DOWN");
        } else if (ev.getAction() == MotionEvent.ACTION_MOVE) {
            Log.e("zeal", "MainActivity onTouchEvent ACTION_MOVE");
        } else if (ev.getAction() == MotionEvent.ACTION_UP) {
            Log.e("zeal", "MainActivity onTouchEvent ACTION_UP");
        }
        Log.e("zeal", "MainActivity onTouchEvent----" + super.onTouchEvent(ev));
        return super.onTouchEvent(ev);
    }
}
