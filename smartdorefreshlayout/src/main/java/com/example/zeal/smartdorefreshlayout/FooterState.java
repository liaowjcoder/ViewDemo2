package com.example.zeal.smartdorefreshlayout;

/**
 * Created by liaowj on 2017/4/14.
 */

public enum FooterState {

    FOOTER_LOADING("正在加载"),
    FOOTER_UP_DRAG("上拉加载更多"),
    FOOTER_PULL_LOADING("松开加载数据");

    private String mDesc;

    private FooterState(String desc) {
        mDesc = desc;
    }

}
