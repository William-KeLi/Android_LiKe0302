package com.example.android_like0302.chapter08;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android_like0302.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class GridView_MyAdapter extends BaseAdapter {
    //1.声明上下文对象和ArrayList集合
    Context context;
    ArrayList<GridView_little_item> datalist;  //数据列表

    //2.创建构造方法，来为成员变量赋初值
    public GridView_MyAdapter(Context context, ArrayList<GridView_little_item> datalist) {
        this.context = context;
        this.datalist = datalist;
    }


   //获取列表长度
    public int getCount() {
       return datalist.size();
    }
   //获取第position项数据
    @Override
    public Object getItem(int position) {
        return datalist.get(position);
    }

    //获取第position项小格的id
    @Override
    public long getItemId(int position) {
        return position;
    }

    //获取每一项数据以什么样式展现出来的视图
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //1.读取小格布局的xml文件，加载到内存中，形成一个View的对象view
        //需要用到布局加载器
        //获取布局加载器
        LayoutInflater layoutInflater =LayoutInflater.from(context);
        //利用布局加载器对象，将xml加载到内存中，并转化为一个View对象
        View view = layoutInflater.inflate(R.layout.gridview_littlebox,null);

        //2.找到View对象中的控件，并将该小格的数据填充到View对象的各个控件中
        //找到小布局中的对应控件
        ImageView little_pic =view.findViewById(R.id.grid_item_picture);
        TextView little_rating=view.findViewById(R.id.grid_item_rating);
        TextView little_name=view.findViewById(R.id.grid_item_name);
        //向控件中填充数据
        GridView_little_item littleItem =datalist.get(position);
        little_pic.setImageResource(littleItem.getImage());
        little_rating.setText(littleItem.getRating());
        little_name.setText(littleItem.getName());

        //3.返回View对象
        return view;
   }
}
