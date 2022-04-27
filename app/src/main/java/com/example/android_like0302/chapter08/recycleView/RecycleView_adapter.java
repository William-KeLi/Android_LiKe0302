package com.example.android_like0302.chapter08.recycleView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_like0302.R;

import java.util.ArrayList;

public class RecycleView_adapter extends RecyclerView.Adapter<RecycleView_adapter.ViewHold> {
    //1.创建上下文对象
    Context context;
    //2.创建数据清单
    ArrayList<RecycleView_littleItem> datalist;
//3.创建构造方法
    public RecycleView_adapter(Context context, ArrayList<RecycleView_littleItem> datalist) {
        this.context = context;
        this.datalist = datalist;
    }

    @NonNull
    @Override
    //4.创建ViewHold并返回
    public ViewHold onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //4.1创建View视图（将小布局视图加载到内存，并转化为View对象）
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.activity_recycleview_littleitem,null);
        //4.2根据View视图，创建ViewHold(前提，需要自己已经创建出ViewHold)
        final ViewHold viewHold=new ViewHold(view);
        //4.3点击在项目上的事件监听器可以写在本方法中
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取小格数据
                int position=viewHold.getAdapterPosition();//使用此方法可以获取是第几个小格
                RecycleView_littleItem item=datalist.get(position);//将数据存储在小格对象中
                //通过Toast将本小格的电视剧名和评分展出出来
                Toast.makeText(context, "这部电视是:"+item.getName()+"，评分是:"+item.getRating(), Toast.LENGTH_SHORT).show();
            }
        });
        //返回ViewHold对象
        return viewHold;
    }


    //5.向ViewHold对象中填充数据，当小格要进入屏幕前
    @Override
    public void onBindViewHolder(@NonNull ViewHold holder, int position) {
        //5.1获得小格要展示的数据
        RecycleView_littleItem item=datalist.get(position);
        //5.2填充到View控件中，展示出来
        holder.image.setImageResource(item.getImage());
        holder.name.setText(item.getName());
        holder.rating.setText(item.getRating());
    }


    @Override
    public int getItemCount() {
        return datalist.size();
    }
    public static class ViewHold extends RecyclerView.ViewHolder {//注意，继承的不是本类的ViewHold，而是RecycleView的ViewHold！！
        View rootView;
        ImageView image;
        TextView name;
        TextView rating;

        public ViewHold(View rootView) {
            super(rootView);
            this.rootView=rootView;
            image = rootView.findViewById(R.id.recycle_picture);
            name = rootView.findViewById(R.id.recycle_name);
            rating = rootView.findViewById(R.id.recycle_rating);
        }
    }
}
