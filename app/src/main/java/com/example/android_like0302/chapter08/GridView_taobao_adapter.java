package com.example.android_like0302.chapter08;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android_like0302.R;

import java.util.ArrayList;

public class GridView_taobao_adapter extends BaseAdapter {
    Context context;
    ArrayList<GridView_taobao_littleItem> datalist;

    public GridView_taobao_adapter(Context context, ArrayList<GridView_taobao_littleItem> datalist) {
        this.context = context;
        this.datalist = datalist;
    }

    @Override
    public int getCount() {
        return datalist.size();
    }

    @Override
    public Object getItem(int position) {
        return datalist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //使用布局加载器
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        //利用布局加载器加载对象，将xml加载到内存，并转化为一个View对象
        View view=layoutInflater.inflate(R.layout.gridview_taobao_little_item,null);

        ImageView imageView=view.findViewById(R.id.grid_taobao_pic);
        TextView textView=view.findViewById(R.id.grid_taobao_name);
         GridView_taobao_littleItem gridView_taobao_littleItem=datalist.get(position);
         imageView.setImageResource(gridView_taobao_littleItem.getImage());
         textView.setText(gridView_taobao_littleItem.getName());
        return view;
    }
}
