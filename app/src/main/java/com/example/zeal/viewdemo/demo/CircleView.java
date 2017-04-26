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
 *
 * 绘制一个圆
 * 中心坐标：宽高的一半
 * 半径：宽与高的最小值的一半
 *
 */

public class CircleView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private int mColor = Color.RED;

    public CircleView(Context context) {
        this(context, null);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = getWidth();
        int height = getHeight();


        int radius = Math.min(width,height)/2;

        canvas.drawCircle(width/2,height/2,radius,mPaint);

    }
}
