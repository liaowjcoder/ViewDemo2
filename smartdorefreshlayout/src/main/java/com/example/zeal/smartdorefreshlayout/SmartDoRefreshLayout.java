package com.example.zeal.smartdorefreshlayout;

import android.content.Context;
import android.content.Loader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by liaowj on 2017/4/14.
 */

public class SmartDoRefreshLayout extends LinearLayout {

    private View mHeaderView;


    public SmartDoRefreshLayout(Context context) {
        this(context, null);
    }

    public SmartDoRefreshLayout(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SmartDoRefreshLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOrientation(VERTICAL);
        initLayout();
    }

    private void initLayout() {



        mHeaderView = View.inflate(this.getContext(), R.layout.default_header_layout, null);
        //View footerView = View.inflate(this.getContext(), getFooterLayoutId(), null);


//        removeAllViews();

        addView(mHeaderView);
        //addView(footerView);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        //测量头部
        //mHeaderView.measure(widthMeasureSpec, heightMeasureSpec);


        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.e("zeal","onMeasure");
    }

    /**
     * 获取头部布局
     *
     * @return
     */
//    public abstract int getHeaderLayoutId();

    /**
     * 获取底部布局
     *
     * @return
     */
//    public abstract int getFooterLayoutId();
    @Override
    public void addView(View child) {

        //判断当前添加的 View 是头部还是底部还是刷新体
        if (child instanceof RefreshHeader) {
            //当前添加的是头部
        } else if (child instanceof LoaderFooter) {
            //当前添加是底部
        } else {
            //当前添加的是刷新体
        }

        super.addView(child);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

//        Log.e("zeal","onFinishInflate");
//
//        LinearLayout.LayoutParams headerLayoutParams = (LayoutParams) mHeaderView.getLayoutParams();
//
//        headerLayoutParams.topMargin = -mHeaderView.getMeasuredHeight();
//
//        mHeaderView.setLayoutParams(headerLayoutParams);

    }
}
