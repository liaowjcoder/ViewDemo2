package com.example.zeal.viewdemo.demo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by liaowj on 2017/4/26.
 * <p>
 * 绘制一个圆
 * 中心坐标：宽高的一半
 * 半径：宽与高的最小值的一半
 * <p>
 * -------
 * 支持 wrap_content
 */

public class CircleView2 extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private int mColor = Color.RED;

    public CircleView2(Context context) {
        this(context, null);
    }

    public CircleView2(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleView2(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

    /**
     * 初始化
     */
    private void init() {
        mPaint.setColor(mColor);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        //支持 warp_content 的情况
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);

        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        if (widthMode == MeasureSpec.AT_MOST && heightMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(200, 200);
        } else if (widthMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(200, heightSize);
        } else if (heightMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(widthSize, 200);
        }else{
            setMeasuredDimension(widthSize,heightSize);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();

        int width = getWidth() - paddingLeft - paddingRight;
        int height = getHeight() - paddingTop - paddingBottom;

        //解决 padding 问题
        int radius = Math.min(width, height) / 2;


        canvas.drawCircle(width / 2 + paddingLeft, height / 2 + paddingTop, radius, mPaint);

    }
}
