package com.example.android_like0302.chapter05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.android_like0302.R;
//内部成员类
public class C03_05_task1 extends AppCompatActivity {
    //1.定义控件变量
    Button button1,button2;
    ImageView imageView1;
    //2.定义一个数组用于存放图片资源
    int[] picture ={R.drawable.t301_chicken,R.drawable.t301_cow,R.drawable.t301_dog,R.drawable.t301_horse,
            R.drawable.t301_rat,R.drawable.t301_mokey};
    int current =0;//用来判断现在是哪一张图片


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c0305_task1);
        init();
    }
    private void init() {
        //3.找到布局中对应的控件
        button1 = (Button) findViewById(R.id.button_task1_1);
        button2 = (Button) findViewById(R.id.button_task1_2);
        imageView1 = (ImageView) findViewById(R.id.imageView_task1);
        //5.绑定事件监听器
        button2.setOnClickListener(new MyListener());
        button1.setOnClickListener(new MyListener());
    }

    //4.创建事件监听器，用内部成员类
    class MyListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            //判断被点击的是哪一个按钮
            switch (view.getId()){
                case R.id.button_task1_1://下一页
                    if(current>=0&&current<=picture.length-2){
                        current++;
                        imageView1.setImageResource(picture[current]);
                    }else if (current==picture.length-1){
                        current=0;
                        imageView1.setImageResource(picture[current]);
                    }
                    break;
                case R.id.button_task1_2:
                    if (current==0){
                        current=picture.length-1;
                        imageView1.setImageResource(picture[current]);
                    }else if (current>0){
                        current--;
                        imageView1.setImageResource(picture[current]);
                    }
                    break;

            }
        }
    }
}