package com.example.android_like0302.chapter08;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.android_like0302.R;

public class C06_09 extends AppCompatActivity {
   ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c0609);
        listView=(ListView) findViewById(R.id.city);
        //定义要显示的数据
        String[] arrs={"潍坊","烟台","临沂","青岛"};
        //将arrs放入成ArrayAdapter
        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<String>(this, android.R.layout.select_dialog_multichoice,arrs);
        //将Adapter对象绑定在ListView上
        listView.setAdapter(arrayAdapter);
    }
}