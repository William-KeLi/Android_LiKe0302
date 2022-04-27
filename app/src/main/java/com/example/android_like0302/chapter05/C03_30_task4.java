package com.example.android_like0302.chapter05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android_like0302.R;

public class C03_30_task4 extends AppCompatActivity {
    TextView textView2;
    ImageView imageView;
    float startX,startY,endX,endY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c0330_task4);
        init();
        //给小球设置事件监听器
        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                //注意：屏幕左上角是坐标原点(0.0)
                //向右延申是X轴的正方向，向下延申是Y轴的正方向

                //判断元事件是按下,移动,抬起那种情况
                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN://触摸按下，获取手指当前的位置,并改变小球的位置
                        //motionEvent.getRawX();表示的是触摸点距离屏幕左边界的距离
                        //motionEvent.getRawY();表示的是触摸点距离屏幕上边界的距离
                        startX=motionEvent.getRawX();
                        startY=motionEvent.getRawY();
                        break;
                    case MotionEvent.ACTION_MOVE://触摸移动,获取手指当前位置，并改变小球的位置
                        //获取手指当前位置的XY坐标
                        endX=motionEvent.getRawX();
                        endY=motionEvent.getRawY();
                        //设置小球的位置为手指当前的位置
                        imageView.setX(endX-100);
                        imageView.setY(endY-230);
                        break;
                     case MotionEvent.ACTION_UP://触摸抬起，计算小球总体偏移方向，并像是在Textview里
                         //获取手指当前的XY坐标
                         endX=motionEvent.getRawX();
                         endY=motionEvent.getRawY();
                         //计算小球偏移的总体方向
                         String result="移动方向";
                         if (endX>startX){
                             result+="右";
                         }else {
                             result+="左";
                         }

                         if (endY>startY){
                             result+="下";
                         }else {
                             result+="上";
                         }

                         //将结果显示在TextView上
                         textView2.setText(result);
                         break;

                }
                //返回true表示已处理该事件
                //如果是false，表示该事件未被处理，此时的MOVE和UP等动作可能无法被监听到
                return true;
            }
        });
    }
    private void init(){
        textView2=(TextView) findViewById(R.id.textView2);
        imageView=(ImageView) findViewById(R.id.imageView);
    }
}