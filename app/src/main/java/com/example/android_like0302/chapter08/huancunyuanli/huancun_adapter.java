package com.example.android_like0302.chapter08.huancunyuanli;

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

public class huancun_adapter extends BaseAdapter {
    //1.声明上下文对象和ArrayList集合
    Context context;
    ArrayList<huancun_littleItem> datalist;  //数据列表

    //2.创建构造方法，来为成员变量赋初值
    public huancun_adapter(Context context, ArrayList<huancun_littleItem> datalist) {
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

    //其实即使我们不用缓存原理，这个方法也自动使用了缓存原理，只是因为我们没有用罢了，所以其中一些步骤，其实系统会自动帮我们做
    public View getView(int position, View convertView, ViewGroup parent) {
        //3.定义一个空的控件缓存器对象
        ViewHolder viewHolder=null;
        //4.根据回收站中是否有缓存的View视图，来选择走哪一条路
        //4.1如果回收站中还没有View的缓存
        if (convertView==null) {
            //使用布局加载其将小布局加载到内存中，并且设置成一个view
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(R.layout.huancun_littleitem, null);
            //创建ViewHold对象
            viewHolder=new ViewHolder(convertView);
            //为了方便服用，将ViewHold作为附件保存到convertView中，这样复用convertView时，就可以直接取出来使用，而不用再findViewById了
            //附件就相当于发送邮件时，你在邮件里发的附件，一个附件就写带了你想发送的信息，在这里的附件里的信息就是对应的布局位置！
            //这一步主要是为了第二次使用缓存视图时使用！！
            //绑定附件的方法时setTag（）
            convertView.setTag(viewHolder);
        }else {//4.2如果回收站中已经有了缓存视图
            viewHolder= (ViewHolder) convertView.getTag();
        }
        //5.将数据填充到View视图中（convertView）
        huancun_littleItem littleItem=datalist.get(position);
        viewHolder.imageView.setImageResource(littleItem.getImage());
        viewHolder.rating.setText(littleItem.getRating());
        viewHolder.name.setText(littleItem.getName());
        //6.将填充好的视图返回
        return convertView;
    }
    //2.创建控件缓存器，便于控件多次利用，避免重复创造，占用空间内存和cpu资源
    class ViewHolder{
        private View rootView;
        private ImageView imageView;
        private TextView name;
        private TextView rating;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            imageView=rootView.findViewById(R.id.huancun_item_picture);
            name=rootView.findViewById(R.id.huancun_item_name);
            rating=rootView.findViewById(R.id.huancun_item_rating);
        }
    }
}
