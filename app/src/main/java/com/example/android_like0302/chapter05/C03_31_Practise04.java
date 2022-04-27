package com.example.android_like0302.chapter05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android_like0302.R;


public class C03_31_Practise04 extends AppCompatActivity {

    TextView activity_p304_tv_result,activity_p304_tv_slide;
    LinearLayout activity_p304_layout;
    float startX,endX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c0331_practise04);

        activity_p304_tv_result = findViewById(R.id.activity_p304_tv_result);
        activity_p304_tv_slide = findViewById(R.id.activity_p304_tv_slide);
        activity_p304_layout = findViewById(R.id.activity_p304_layout);

        //给黄色区域设置触摸事件监听器
        activity_p304_layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {


                float left = 0;

                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        startX = event.getRawX();
                        break;
                    case MotionEvent.ACTION_MOVE:

                        endX = event.getX();


                        //滑块活动区域layout的左上角为原点(0,0)
                        if(endX < 0) {
                            activity_p304_tv_slide.setX(0);
                            activity_p304_tv_result.setText("触摸位置的X："+endX+"；黄色滑动区域的X："
                                    +activity_p304_layout.getX()+"；滑块位置的X："+activity_p304_tv_slide.getX());
                        }else if(endX > 360) {
                            activity_p304_tv_slide.setX(360);
                            activity_p304_tv_result.setText("触摸位置的X："+endX+"；黄色滑动区域的X："
                                    +activity_p304_layout.getX()+"；滑块位置的X："+activity_p304_tv_slide.getX());
                        }else {
                            activity_p304_tv_slide.setX(endX);
                            activity_p304_tv_result.setText("触摸位置的X："+endX+"；黄色滑动区域的X："
                                    +activity_p304_layout.getX()+"；滑块位置的X："+endX);
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        endX = event.getRawX();
                        //计算小球偏移总方向
                        String result = "移动方向：";
                        if(endX > startX )
                            result += "右";
                        else if(endX < startX )
                            result += "左";

                        //将结果显示在textView上
                        activity_p304_tv_result.setText(result);
                        break;

                }
                return true;
            }
        });
    }
}