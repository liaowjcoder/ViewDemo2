package com.example.zeal.scrollerdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Scroller;

public class MainActivity extends AppCompatActivity {
    private ImageView mIv;

    private Scroller mScroller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mScroller = new Scroller(this);

        mIv = (ImageView) findViewById(R.id.imageview);

        mIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //在已有的位置上，往左上角移动10个像素
                mIv.scrollBy(10, 10);
            }
        });
    }


}
