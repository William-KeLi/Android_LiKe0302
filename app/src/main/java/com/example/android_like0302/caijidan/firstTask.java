package com.example.android_like0302.caijidan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android_like0302.R;

public class firstTask extends AppCompatActivity implements View.OnClickListener {
    TextView textView;
    Button button;
    ImageView imageView1,imageView2,imageView3;
    int image[]={R.drawable.e301_shoe_default,R.drawable.e301_shoe_ok,R.drawable.e301_shoe_sorry};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_task);
        init();
    }
    private void init(){
        textView = findViewById(R.id.textView52);
        button = findViewById(R.id.button36);
        imageView1 = findViewById(R.id.imageView31);
        imageView2 = findViewById(R.id.imageView32);
        imageView3 = findViewById(R.id.imageView33);
        button.setOnClickListener(this);
        imageView1.setOnClickListener(this);
        imageView2.setOnClickListener(this);
        imageView3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int num1 = (int)(Math.random()*3);
        switch (v.getId()){
            case R.id.button36:
                imageView1.setImageResource(image[0]);
                imageView2.setImageResource(image[0]);
                imageView3.setImageResource(image[0]);
                break;
            case R.id.imageView31:
                if (num1==0){
                    imageView1.setImageResource(image[1]);
                    imageView2.setImageResource(image[2]);
                    imageView3.setImageResource(image[2]);
                    textView.setText("恭喜你猜对了");
                }else if (num1==1){
                    imageView1.setImageResource(image[2]);
                    imageView2.setImageResource(image[1]);
                    imageView3.setImageResource(image[2]);
                    textView.setText("很抱歉，您猜错了，要不要再试一次？");
                }else if (num1==2){
                    imageView1.setImageResource(image[2]);
                    imageView2.setImageResource(image[2]);
                    imageView3.setImageResource(image[1]);
                    textView.setText("很抱歉，您猜错了，要不要再试一次？");
                }


                break;
            case R.id.imageView32:
                if (num1==0){
                    imageView1.setImageResource(image[1]);
                    imageView2.setImageResource(image[2]);
                    imageView3.setImageResource(image[2]);
                    textView.setText("很抱歉，您猜错了，要不要再试一次？");
                }else if (num1==1){
                    imageView1.setImageResource(image[2]);
                    imageView2.setImageResource(image[1]);
                    imageView3.setImageResource(image[2]);
                    textView.setText("恭喜你猜对了");
                }else if (num1==2){
                    imageView1.setImageResource(image[2]);
                    imageView2.setImageResource(image[2]);
                    imageView3.setImageResource(image[1]);
                    textView.setText("很抱歉，您猜错了，要不要再试一次？");
                }
                break;
            case R.id.imageView33:
                if (num1==0){
                    imageView1.setImageResource(image[1]);
                    imageView2.setImageResource(image[2]);
                    imageView3.setImageResource(image[2]);
                    textView.setText("很抱歉，您猜错了，要不要再试一次？");
                }else if (num1==1){
                    imageView1.setImageResource(image[2]);
                    imageView2.setImageResource(image[1]);
                    imageView3.setImageResource(image[2]);
                    textView.setText("很抱歉，您猜错了，要不要再试一次？");
                }else if (num1==2){
                    imageView1.setImageResource(image[2]);
                    imageView2.setImageResource(image[2]);
                    imageView3.setImageResource(image[1]);
                    textView.setText("恭喜你猜对了");
                }
                break;
        }
    }
}