package com.example.zeal.scrollerdemo.ex_outer;

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

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_ex);


        HorizontalScrollViewEx container = (HorizontalScrollViewEx) findViewById(R.id.container);
        LayoutInflater inflater = getLayoutInflater();
        int screenWidth = MyUtils.getScreenMetrics(this).widthPixels;
        int screenHeight = MyUtils.getScreenMetrics(this).heightPixels;


        for (int i = 0; i < 3; i++) {
            ViewGroup layout = (ViewGroup) inflater.inflate(
                    R.layout.content_layout, container, false);

            ListView listView = (ListView) layout.findViewById(R.id.list);
            TextView textView
                    = (TextView) layout.findViewById(R.id.title);

            layout.getLayoutParams().width = screenWidth;
            textView.setText("当前是第"+(i+1)+"个页面");

            layout.setBackgroundColor(Color.rgb(255 / (i + 1), 255 / (i + 1), 0));

            createListView(listView);

            container.addView(layout);


        }

    }

    private void createListView(ListView listView) {
        ArrayList<String> datas = new ArrayList<String>();
        for (int i = 0; i < 50; i++) {
            datas.add("name " + i);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.content_list_item, R.id.name, datas);
        listView.setAdapter(adapter);
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
