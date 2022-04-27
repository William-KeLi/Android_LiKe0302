package com.example.android_like0302.chapter08;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import com.example.android_like0302.R;

import java.util.ArrayList;

public class GridView_taobao_mainActivity extends AppCompatActivity {
    GridView gridView;
    ArrayList<GridView_taobao_littleItem> datalist;
    int [] image ={R.drawable.p603_img01,R.drawable.p603_img02,R.drawable.p603_img03,R.drawable.p603_img04,
            R.drawable.p603_img05,R.drawable.p603_img06,R.drawable.p603_img07,R.drawable.p603_img08,R.drawable.p603_img09,
            R.drawable.p603_img10};
    String [] name={"天猫商城","今日爆款","天猫国际","天猫农场","天猫超市","充值中心","机票酒店","领淘金币","阿里拍卖","淘宝吃货"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view_taobao_main);
        init();
    }
    private void init(){
        gridView=findViewById(R.id.grid_taobao);
        storeData();
        GridView_taobao_adapter adapter=new GridView_taobao_adapter(GridView_taobao_mainActivity.this,datalist);
        gridView.setAdapter(adapter);
    }

    private void storeData() {
        datalist=new ArrayList<>();
        for (int i = 0; i <image.length ; i++) {
            GridView_taobao_littleItem movie =new GridView_taobao_littleItem(image[i],name[i]);
            datalist.add(movie);
        }
    }
}