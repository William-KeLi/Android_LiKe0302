package com.example.android_like0302.chapter08;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.android_like0302.R;

public class C06_42_activity extends AppCompatActivity implements View.OnClickListener {
    //1.先初始化控件
    private TextView xiaohuanxi,changan;
    //2.实现点击事件监听器，并重写其回调方法

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c0642);
        init();
    }
    private void init(){
        xiaohuanxi=(TextView) findViewById(R.id.f1_xiaohuanxi);
        changan=(TextView) findViewById(R.id.f2_changan);
        xiaohuanxi.setOnClickListener(this);
        changan.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //3.创建Fragment对象
        FragmentManager fragmentManager=getSupportFragmentManager();

        //4.使用fragment对象创建FragmentTransaction对象，并使用它去加载Fragment
        FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();

        //5.创建Fragment碎片对象
        Fragment fxiaohuanxi = new C06_42_f1();
        Fragment fchangan = new C06_42_f2();

        switch (v.getId()){
            case R.id.f1_xiaohuanxi://加载小欢喜图片
                fragmentTransaction.replace(R.id.movies1,fxiaohuanxi);//两个参数分别为，Activity中想要Fragment显示的位置的id，第二个
                   //是哪一个碎片
                break;
            case R.id.f2_changan://加载长安图片
                fragmentTransaction.replace(R.id.movies1,fchangan);
                break;
        }
        //6.一定要提交！!!
        fragmentTransaction.commit();
    }
}