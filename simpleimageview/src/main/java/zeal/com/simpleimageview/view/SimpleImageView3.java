package zeal.com.simpleimageview.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import zeal.com.simpleimageview.R;

/**
 * Created by liaowj on 2017/5/17.
 */
public class SimpleImageView3 extends View {
    private Paint mPaint;
    private int mWidth;
    private int mHeight;

    private Drawable mDrawable;

    public SimpleImageView3(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.SimpleImageView);

        int src = typedArray.getIndex(R.styleable.SimpleImageView_src);


        mDrawable = typedArray.getDrawable(R.styleable.SimpleImageView_src);

        typedArray.recycle();

        init(mDrawable);
    }

    private void init(Drawable drawable) {
        mWidth = drawable.getIntrinsicWidth();
        mHeight = drawable.getIntrinsicHeight();
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int width = MeasureSpec.getSize(widthMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);

        int height = MeasureSpec.getSize(heightMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);


        setMeasuredDimension(measureWidth(widthMode, width), measureHeight(height, heightMode));
    }

    private int measureHeight(int height, int heightMode) {
        switch (heightMode) {
            case MeasureSpec.AT_MOST:
            case MeasureSpec.UNSPECIFIED:
                break;
            case MeasureSpec.EXACTLY://确定的值就传入 width
                mHeight = height;
                break;
        }
        return mHeight;
    }

    private int measureWidth(int widthMode, int width) {

        switch (widthMode) {
            case MeasureSpec.AT_MOST:
            case MeasureSpec.UNSPECIFIED:
                break;
            case MeasureSpec.EXACTLY://确定的值就传入 width
                mWidth = width;
                break;
        }
        return mWidth;

    }

    @Override
    protected void onDraw(Canvas canvas) {

        //draw bitmap
        Bitmap bitmap = Bitmap.createScaledBitmap(ImageUtils.drawableToBitmap(mDrawable), getMeasuredWidth(), getMeasuredHeight(), true);

        canvas.drawBitmap(bitmap, getLeft(), getTop(), mPaint);

        //drawText

        //save
        canvas.save();

        //逆時針旋轉 90°
        canvas.rotate(90);

        mPaint.setColor(Color.RED);
        mPaint.setTextSize(30);
        //旋转之后的原点位置发生了变化(逆时针旋转)
        //x 越大，越靠右
        //y 约小，越往上偏移
        canvas.drawText("by zeal", getLeft() + 50, getTop() - 200, mPaint);

        //恢复到原始状态
        canvas.restore();
    }
}
