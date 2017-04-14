package com.example.zeal.smartdorefreshlayout;

/**
 * Created by liaowj on 2017/4/14.
 */

public enum HeaderState {
    //正在刷新
    HEADER_REFRESHING("正在刷新"),
    //下拉刷新
    HEADER_DOWN_DRAG("下拉刷新"),
    //松开刷新
    HEADER_PULL_REFRESHING("松开刷新");

    private String mDesc;

    private HeaderState(String msg) {
        mDesc = msg;
    }
}
