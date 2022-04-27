package com.example.android_like0302.chapter08;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.android_like0302.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class C06_11 extends AppCompatActivity {
    //1.定义视图对象
    private ListView C0611;

    //2.准备要展示的数据
    int[] images={R.drawable.t602_sanzang,R.drawable.t602_wukong,R.drawable.t602_bajie,
            R.drawable.t602_shaseng,R.drawable.t602_baima};//图片资源
    String[] names=new String[]{"唐增","悟空","八戒","沙憎","白龙马"};//人物姓名
    String[] introduces=new String[]{"我的肉，能长生！","我的头很铁","我很能吃，爱美人","我也曾经潇洒过","说出来你可能不信，其实我是条龙"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c0611);
        init();
    }
    private void init(){
        C0611=(ListView) findViewById(R.id.xiyou);
        //3.定义List集合，准备存放数据
        List<Map<String,Object>> list = new ArrayList<>();
        //4.通过for循环将数据存入Map集合中，再将Map存入List中；
        for (int i=0;i<=4;i++){
            HashMap user = new HashMap();
            user.put("header",images[i]);
            user.put("name",names[i]);
            user.put("introduce",introduces[i]);

            list.add(user);
        }
        //5.创建Adapter对象
        SimpleAdapter simpleAdapter =new SimpleAdapter(this,list,R.layout.littlie_buju,
                new String[]{"header","name","introduce"},
                new int[]   {R.id.imageView27,R.id.little_name,R.id.little_intro});

        //6.将Adapter绑定到ListView上
        C0611.setAdapter(simpleAdapter);

        //7.给ListView添加监听器
        C0611.setOnItemClickListener((parent, view, position, id) -> {
            //取出信息
            Map user =(Map) parent.getItemAtPosition(position);
            //获得用户姓名
            String name =(String) user.get("name");
            //展示
            Toast.makeText(this, "你选择的是"+name, Toast.LENGTH_SHORT).show();
        });
        }


}