package com.example.android_like0302.chapter08;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.android_like0302.R;

public class C06_07_XMLandXMLJavashixian extends AppCompatActivity {
    ListView textlist1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c0607_xmlshixian);
        textlist1=(ListView) findViewById(R.id.textlist1);
        //数据准备
        String[] arr={"李克","曹云逸","王志鹏","渣男岭"};
        //将数据包裹为ArrayAdapter
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,arr);
        //将ArrayAdapter绑定到ListView对象上
        textlist1.setAdapter(arrayAdapter);
    }
}