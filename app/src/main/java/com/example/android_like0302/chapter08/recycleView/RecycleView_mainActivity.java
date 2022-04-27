package com.example.android_like0302.chapter08.recycleView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.android_like0302.R;

import java.util.ArrayList;

public class RecycleView_mainActivity extends AppCompatActivity {
   //1.先声明好RecycleView对象
    RecyclerView recyclerView;
    //2.去创建小布局的java类和xml文件
    //3.去创建适配器实例
    //4.数据准备
    int[] image={R.drawable.t603_img01,R.drawable.t603_img02,R.drawable.t603_img03,R.drawable.t603_img04,
            R.drawable.t603_img05,R.drawable.t603_img06,R.drawable.t603_img07,R.drawable.t603_img08,
            R.drawable.t603_img09,R.drawable.t603_img10,R.drawable.t603_img11,R.drawable.t603_img12,
            R.drawable.t603_img13,R.drawable.t603_img14,R.drawable.p604_img15,R.drawable.p604_img16,
            R.drawable.p604_img17,R.drawable.p604_img18,R.drawable.p604_img19,R.drawable.p604_img20};
    String []name={"小欢喜","长安十二时辰","宸汐缘","大宋少年志","庆余年","大江大河","天盛长歌","白夜追凶","你好，旧时光",
            "琅琊榜之风起长林","人民的名义","河神","无证之罪","大军师司马懿","最好的我们","余罪","精绝古城","琅琊榜","伪装者","无心法师"};
    String []rating={"8.4","8.3","8.3","8.2","8.0","8.8","8.1","9.0","8.7","8.5","8.3","8.2","8.2","8.2","8.9","8.4",
            "8.0","9.3","8.5","8.4"};
    //5.声明好集合
    ArrayList<RecycleView_littleItem> datalist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view_main);
        init();
    }
    private void init(){
        //6.控件初始化
        recyclerView=findViewById(R.id.recycle_main_activity);
        //7.数据填充
        storeData();
        //8.创建适配器实例对象
        RecycleView_adapter adapter=new RecycleView_adapter(RecycleView_mainActivity.this,datalist);
        //9.给RecycleView绑定适配器
        recyclerView.setAdapter(adapter);
        //10.创建LayoutManager对象（用什么视图就创建什么视图，这里我创建的是GridView）
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
        //11.对RecycleView设置布局管理器
        recyclerView.setLayoutManager(gridLayoutManager);

    }

    private void storeData() {
        //创建Ayyaylist对象
        datalist=new ArrayList<>();
        RecycleView_littleItem item;
        for (int i = 0; i <image.length ; i++) {
            item=new RecycleView_littleItem(image[i],name[i],rating[i]);
            datalist.add(item);
        }
    }
}