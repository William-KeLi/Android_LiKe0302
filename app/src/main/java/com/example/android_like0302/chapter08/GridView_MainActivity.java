package com.example.android_like0302.chapter08;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.android_like0302.R;

import java.util.ArrayList;

public class GridView_MainActivity extends AppCompatActivity {
  //1.创建GridView的对象
    GridView gridView;

    //2.准备原始数据(名字必须和小布局对象中定义的一样！！！！！！！！！！！！！！)
     int[] image={R.drawable.t603_img01,R.drawable.t603_img02,R.drawable.t603_img03,R.drawable.t603_img04,
            R.drawable.t603_img05,R.drawable.t603_img06,R.drawable.t603_img07,R.drawable.t603_img08,
            R.drawable.t603_img09,R.drawable.t603_img10,R.drawable.t603_img11,R.drawable.t603_img12,
            R.drawable.t603_img13,R.drawable.t603_img14};
     String []name={"小欢喜","长安十二时辰","宸汐缘","大宋少年志","庆余年","大江大河","天盛长歌","白夜追凶","你好，旧时光","琅琊榜之风起长林","人民的名义","河神","无证之罪","大军师司马懿"};
     String []rating={"8.4","8.3","8.3","8.2","8.0","8.8","8.1","9.0","8.7","8.5","8.3","8.2","8.2","8.2"};


     //2.定义数据列表
    ArrayList<GridView_little_item> dataist;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view_main);
        init();
    }

    private void init() {
        gridView = findViewById(R.id.main_gridview);
        //3.初始化数据列表ArrayAdapter<>
           //因为这部需要将各个苏剧存放到小布局对象中，再放入数据列表ArrayList中，所以这里单独再创建一个方法，完成此步
        storeData();

        //4.创建BaseAdapter实例
        GridView_MyAdapter adapter=new GridView_MyAdapter(GridView_MainActivity.this,dataist);


        //5.将BaseAdapter实例绑定在GridView上

        gridView.setAdapter(adapter);
        //6.对GridView设置监听器
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //获取本小格的数据
                GridView_little_item littleItem=dataist.get(position);
                //将小格数据展示在Toast的提示框上
                Toast.makeText(GridView_MainActivity.this, "你点击的是"+littleItem.getName(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
       //进行数据存储专用方法
    private void storeData() {
         //首先将ArrayList创建对象
        dataist=new ArrayList<>();
        //使用for循环将戈尔戈数据传入到小布局对象中去，并且在传入到Arraylist中
        for (int i = 0; i <image.length ; i++) {
            GridView_little_item movie=new GridView_little_item(image[i],rating[i],name[i]);
            dataist.add(movie);
        }
    }
}