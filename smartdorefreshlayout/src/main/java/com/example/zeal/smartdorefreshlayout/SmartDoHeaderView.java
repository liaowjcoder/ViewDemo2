package com.example.zeal.smartdorefreshlayout;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

/**
 * Created by liaowj on 2017/4/14.
 */

public class SmartDoHeaderView implements RefreshHeader {


    private Context mContext;

    public SmartDoHeaderView(Context context) {
        this.mContext = context;
    }

    @Override
    public View getHeaderLayoutView() {

        TextView textView = new TextView(mContext);
        textView.setText("我是刷新头部");
        return textView;
    }

    @Override
    public HeaderState getHeaderState() {
        return null;
    }
}
