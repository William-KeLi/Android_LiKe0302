package com.example.android_like0302.chapter08.fragment_tongxin;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android_like0302.R;


public class ContentFragment extends Fragment {
    int[] image;
    String[] rating;
    String [] name;
    String[] introduce;
    Fragment_mainac mainac;
    ImageView imageView;
    TextView Rating,Name,Introduce;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //1.获取宿主Activity
        mainac= (Fragment_mainac) getActivity();
        //2.获取宿主Activity中的数据
        image=mainac.getImage();
        name=mainac.getName();
        rating=mainac.getRating();
        introduce=mainac.getIntroduce();

        //3.创建View
        View view=inflater.inflate(R.layout.fragment_content, container, false);
        // 4.初始化控件
        imageView=view.findViewById(R.id.imageView34);
        Name=view.findViewById(R.id.fgtongxin_tvname);
        Rating=view.findViewById(R.id.fgtongxin_rating);
        Introduce=view.findViewById(R.id.fgtongxin_introd);

        //5.初始化显示资源
        imageView.setImageResource(image[0]);
        Name.setText(name[0]);
        Rating.setText(rating[0]);
        Introduce.setText(introduce[0]);
        return view;
    }
    public void setImage(int i){
        imageView.setImageResource(image[i]);
    }
    public void setName(int i){
        Name.setText(name[i]);
    }
    public void setRating(int i){
        Rating.setText(rating[i]);
    }
    public void setIntroduce(int i){
        Introduce.setText(introduce[i]);
    }
}