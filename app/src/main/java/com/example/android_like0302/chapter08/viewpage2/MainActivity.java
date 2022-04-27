package com.example.android_like0302.chapter08.viewpage2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.android_like0302.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //创建数据页对象，方便设定监视器
    private ViewPager2 viewPager2;
    //创建数据页对象集合（也就是Fragment集合）
    ArrayList<Fragment> datelist;

    //创建一个状态，事件监听器会用到
    int theState=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();
        //初始化数据页对象集合(也就是向里面添加3个Fragment对象)
        initData();
        //创建一个自定义适配器（在下面创建，是一个内部类）

        //创建自定义适配器对象
        MyViewPageAdapter adapter=new MyViewPageAdapter(this);
        //为ViewPage绑定适配器
        viewPager2.setAdapter(adapter);
        //为ViewPage绑定时间监听器
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {

            //当屏幕滑动时
            @Override
            //形参解释
            //position:第几个页面
            // positionoffset：视图滑动便宜的百分比（向左滑动，也就是显示右边页面的百分比）
            //positionoffsetPixels：视图滑动偏移量的绝对值，有第二个参数成正比
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
               //是最后一页吗
                boolean isFinal=position==datelist.size()-1;
                //用户正在手指滑动屏幕吗
                boolean moving=theState==1;
                //屏幕偏移了吗
                boolean ispianyi=positionOffset==0;
                //如果三个条件都满足，我们就关闭关闭Acivity
                if (ispianyi==true&&moving==true&&isFinal==true){
                    finish();
                }
            }
           //当选中第position画面时
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
            }
            //state:0无事件  1正在滑动  2事件结束
            @Override
            public void onPageScrollStateChanged(int state) {
                theState=state;
            }
        });

    }

    private void initData() {
        datelist=new ArrayList<>();
        datelist.add(new Fragment1());
        datelist.add(new Fragment2());
        datelist.add(new Fragment3());
    }

    private void init(){
        //初始化数据页对象
        viewPager2=findViewById(R.id.firstviewPager2);
    }


    //自定义的适配器
    class MyViewPageAdapter extends FragmentStateAdapter{

        public MyViewPageAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }
     //修改方法
        @NonNull
        @Override
        //此方法是为了获得第position个的Fragment对象
        public Fragment createFragment(int position) {
            return datelist.get(position);
        }
        //此方法是为了获取一共要i显示几个Fragment
        @Override
        public int getItemCount() {
            return datelist.size();
        }
    }
}