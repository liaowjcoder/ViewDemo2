package zeal.com.simpleimageview.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import zeal.com.simpleimageview.R;

/**
 * Created by liaowj on 2017/5/17.
 */
public class SimpleImageView2 extends View {
    private Paint mPaint;
    private int mWidth;
    private int mHeight;

    private Drawable mDrawable;

    public SimpleImageView2(Context context, @Nullable AttributeSet attrs) {
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

        Bitmap bitmap = Bitmap.createScaledBitmap(ImageUtils.drawableToBitmap(mDrawable), getMeasuredWidth(), getMeasuredHeight(), true);

        canvas.drawBitmap(bitmap, getLeft(), getTop(), mPaint);

    }
}
