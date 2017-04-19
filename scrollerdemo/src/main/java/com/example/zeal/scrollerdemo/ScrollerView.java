package com.example.zeal.scrollerdemo;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;
import android.widget.Scroller;


/**
 * Created by liaowj on 2017/4/14.
 */

public class ScrollerView extends android.support.v7.widget.AppCompatImageView {
    private Scroller mScroller;

    public ScrollerView(Context context, AttributeSet attrs) {
        super(context, attrs);
//        mScroller = new Scroller(context);
//
//        //这段代码的作用只是对 Scroller 的中变量做一些赋值工作，并不会产生什么滑动操作
//        mScroller.startScroll(this.getScrollX(), this.getScrollY(), -100, -100, 2000);
//        //负责激发重新绘制操作，使得 computeScroll 进行重新绘制
//        invalidate();

        //动画的方式使用移动view
        //animation();

    }


    private void animation() {

        //ObjectAnimator.ofFloat(this,"translationX",0,100).setDuration(5000).start();

        //动画的方式实现scrollTo
        final int startX = 0;
        final int deltaX = -100;
        ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 100).setDuration(3000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                //得到动画当前帧的百分比
                float fraction = animation.getAnimatedFraction();
                //根据动动画当前帧百分比计算应该滑动的距离
                scrollTo((int) (startX + deltaX * fraction), 0);
            }
        });
        valueAnimator.start();

    }


//    @Override
//    public void computeScroll() {
//        super.computeScroll();
//        //computeScrollOffset 根据时间计算当前的 scrollX 和 scrollY 的值
//        if (mScroller.computeScrollOffset()) {
//            //真正滑动的地方
//            scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
//        }
//    }
}
