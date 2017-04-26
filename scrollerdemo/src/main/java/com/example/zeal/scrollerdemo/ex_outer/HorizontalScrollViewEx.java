package com.example.zeal.scrollerdemo.ex_outer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;

/**
 * Created by liaowj on 2017/4/20.
 * 外部拦截法
 */

public class HorizontalScrollViewEx extends ViewGroup {
    public HorizontalScrollViewEx(Context context) {
        super(context);
        init();
    }

    public HorizontalScrollViewEx(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public HorizontalScrollViewEx(Context context, AttributeSet attrs,
                                  int defStyle) {
        super(context, attrs, defStyle);
        init();
    }


    private int mLastInterceptX;
    private int mLastInterceptY;

    private int mLastX;
    private int mLastY;

    private int mChildIndex;
    private int mChildrenSize;
    private int mChildWidth;

    private Scroller mScroller;
    private VelocityTracker mVelocityTracker;

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int x = (int) ev.getX();
        int y = (int) ev.getY();

        boolean intercept = false;

        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                intercept = false;
                break;
            case MotionEvent.ACTION_MOVE:

                int deltaX = x - mLastInterceptX;
                int deltaY = y - mLastInterceptY;

                if (Math.abs(deltaX) > Math.abs(deltaY)) {//水平>竖直 需要拦截
                    intercept = true;
                } else {
                    intercept = false;
                }
                break;
            case MotionEvent.ACTION_UP:
                intercept = false;
                break;
        }

        mLastInterceptX = x;
        mLastInterceptY = y;

        //这里也要赋值的原因是：当 move 事件被当前 View 所拦截了，那么该 View 的 onTouchEvent 方法会被回调
        //那么就会进入 onTouchEvent 中 move 事件中。
        mLastX = x;
        mLastY = y;

        return intercept;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        mVelocityTracker.addMovement(ev);
        //记录当前手指滑动到的位置
        int x = (int) ev.getX();
        int y = (int) ev.getY();

        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:



                /*
                what:mLastX 和 mLastY 是记录上次滑动的位置坐标。
                when:当事件在被拦截之后，之间就会进入 onTouchEvent 中进入的是 case 为 move 的分支中。

                若当前坐标:mLastX,mLastY(100，50)

                那么在中的 onTouchEvent 的坐标
                x 100
                y 50
                那么得到的间距就是 0 ；
                delta = 0

                这样在过度阶段时  发生的 scrollBy(-deltaX,0)
                就不会滑动了，而是再次发生的 move 事件才会有 deltaX 的值。

                why：
                假设在 onInterceptTouchEvent 中不对 mLastX 和 mLastY 做赋值操作的话，那么 mLastX 和 mLastY 的值
                就为 0 ，那么在 onTouchEvent 中的 move 的分支中得到的 delta 值就不会为 0 了，那么肯定在滑动就会出现
                跳动现象。

                how: 在 onInterceptTouchEvent 每次都对 mLastX 和 mLastY 做赋值操作。
                 */


                //得到当前位置和上次位置的间距
                int deltaX = x - mLastX;
                int deltaY = y - mLastY;

                scrollBy(-deltaX, 0);

                break;
            case MotionEvent.ACTION_UP:
                int scrollX = getScrollX();
                int scrollToChildIndex = scrollX / mChildWidth;
                mVelocityTracker.computeCurrentVelocity(1000);
                float xVelocity = mVelocityTracker.getXVelocity();
                if (Math.abs(xVelocity) >= 50) {
                    mChildIndex = xVelocity > 0 ? mChildIndex - 1 : mChildIndex + 1;
                } else {
                    mChildIndex = (scrollX + mChildWidth / 2) / mChildWidth;
                }
                mChildIndex = Math.max(0, Math.min(mChildIndex, mChildrenSize - 1));
                int dx = mChildIndex * mChildWidth - scrollX;
                smoothScrollBy(dx, 0);
                mVelocityTracker.clear();

                break;
        }
        //记录上次手指滑动到的位置
        mLastX = x;
        mLastY = y;
        return true;
    }

    private void init() {
        mScroller = new Scroller(getContext());
        mVelocityTracker = VelocityTracker.obtain();
    }

    private void smoothScrollBy(int dx, int dy) {

        mScroller.startScroll(getScrollX(), 0, dx, dy, 500);
        invalidate();
    }

    @Override
    public void computeScroll() {
        super.computeScroll();

        if (mScroller.computeScrollOffset()) {
            scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            postInvalidate();
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        mVelocityTracker.recycle();
        super.onDetachedFromWindow();
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int measuredWidth = 0;
        int measuredHeight = 0;
        final int childCount = getChildCount();
        //测量所有的孩子
        measureChildren(widthMeasureSpec, heightMeasureSpec);

        //没有考虑 padding 和子元素的 margin 问题

        //获取父控件的期望的模式和大小
        int widthSpaceSize = MeasureSpec.getSize(widthMeasureSpec);
        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightSpaceSize = MeasureSpec.getSize(heightMeasureSpec);
        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        if (childCount == 0) {//没有孩子时，设置当前控件大小为 0
            setMeasuredDimension(0, 0);
        } else if (widthSpecMode == MeasureSpec.AT_MOST && heightSpecMode == MeasureSpec.AT_MOST) {//宽和高都是 wrap_content 的情况
            //宽和高设置由第一个孩子决定
            final View childView = getChildAt(0);
            measuredWidth = childView.getMeasuredWidth();
            measuredHeight = childView.getMeasuredHeight();
            //根据孩子的大小测量自己
            setMeasuredDimension(measuredWidth * childCount, measuredHeight);
        } else if (heightSpecMode == MeasureSpec.AT_MOST) {//当前控件
            final View childView = getChildAt(0);
            measuredHeight = childView.getMeasuredHeight();
            setMeasuredDimension(widthSpaceSize, measuredHeight);
        } else if (widthSpecMode == MeasureSpec.AT_MOST) {
            final View childView = getChildAt(0);
            measuredWidth = childView.getMeasuredWidth() * childCount;
            setMeasuredDimension(measuredWidth, heightSpaceSize);
        } else {
            final View childView = getChildAt(0);
            measuredWidth = childView.getMeasuredWidth() * childCount;
            measuredHeight = childView.getMeasuredHeight();
            setMeasuredDimension(measuredWidth, measuredHeight);
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childLeft = 0;
        final int childCount = getChildCount();
        mChildrenSize = childCount;

        //没有考虑 padding 和子元素的 margin 问题
        for (int i = 0; i < childCount; i++) {
            final View childView = getChildAt(i);
            if (childView.getVisibility() != View.GONE) {
                final int childWidth = childView.getMeasuredWidth();
                mChildWidth = childWidth;
                childView.layout(childLeft, 0, childLeft + childWidth,
                        childView.getMeasuredHeight());
                childLeft += childWidth;
            }
        }
    }
}
