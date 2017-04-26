package com.example.zeal.scrollerdemo.ex_inner;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zeal.scrollerdemo.R;
import com.example.zeal.scrollerdemo.ex_inner.HorizontalScrollViewEx;
import com.example.zeal.scrollerdemo.ex_outer.MyUtils;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    HorizontalScrollViewEx container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_ex2);


        container = (HorizontalScrollViewEx) findViewById(R.id.container);
        LayoutInflater inflater = getLayoutInflater();
        int screenWidth = MyUtils.getScreenMetrics(this).widthPixels;


        for (int i = 0; i < 3; i++) {
            ViewGroup layout = (ViewGroup) inflater.inflate(
                    R.layout.content_layout2, container, false);


            TextView textView
                    = (TextView) layout.findViewById(R.id.title);

            layout.getLayoutParams().width = screenWidth;
            textView.setText("当前是第" + (i + 1) + "个页面");

            layout.setBackgroundColor(Color.rgb(255 / (i + 1), 255 / (i + 1), 0));

            createListView(layout);

            container.addView(layout);


        }

    }

    private void createListView(ViewGroup layout) {
        ListViewEx listView = (ListViewEx) layout.findViewById(R.id.list);
        ArrayList<String> datas = new ArrayList<String>();
        for (int i = 0; i < 50; i++) {
            datas.add("name " + i);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.content_list_item, R.id.name, datas);
        listView.setAdapter(adapter);
        listView.setHorizontalScrollViewEx2(container);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(MainActivity.this, "click item",
                        Toast.LENGTH_SHORT).show();

            }
        });

    }

}
