package storage.zeal.com.timelineview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by liaowj on 2017/5/3.
 */

public class LineView extends View {
    private Paint mPaint;

    private static final String TAG = "LineView";

    public LineView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        Log.e(TAG, "widthSize : " + widthSize);
        Log.e(TAG, "heightSize : " + heightSize);

        int resultWidth = 0;
        int resultHeight = heightSize;

        if (widthMode == MeasureSpec.AT_MOST && heightMode == MeasureSpec.AT_MOST) {
            resultWidth = dip2Px(35);
        } else if (widthMode == MeasureSpec.AT_MOST) {
            resultWidth = dip2Px(35);
        }
        setMeasuredDimension(resultWidth, resultHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(Color.parseColor("#A9A9A9"));
        mPaint.setStrokeWidth(5);
        canvas.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight(), mPaint);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.icon_checked);
        canvas.drawBitmap(bitmap, getWidth() / 2 - bitmap.getWidth() / 2, getHeight() / 2 - bitmap.getHeight() / 2, mPaint);
    }

    public int dip2Px(int dip) {
        float density = getResources().getDisplayMetrics().density;

        int px = (int) (density * dip + .5f);
        return px;
    }
}
