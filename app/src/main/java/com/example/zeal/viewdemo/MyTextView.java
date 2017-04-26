package com.example.zeal.viewdemo;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * Created by liaowj on 2017/4/25.
 */

public class MyTextView extends android.support.v7.widget.AppCompatTextView {
    public MyTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Log.e("zeal", "-width:" + MeasureSpec.getSize(widthMeasureSpec));
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.e("zeal", "width-:" + MeasureSpec.getSize(widthMeasureSpec));
    }
}
