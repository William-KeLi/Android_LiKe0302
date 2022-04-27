package com.example.android_like0302.chapter05;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android_like0302.R;

public class C03_17_task2 extends AppCompatActivity implements View.OnClickListener {
   //列出事件所需要的所有资源
    //图片相关
    int[] picture=new int[]{R.drawable.t302_cloth,R.drawable.t302_scissors,R.drawable.t302_stone};
    //控件相关
    ImageView imageViewphone;
    TextView textView6;
    //这个是button，不用管
    Button button35;
    //定义计数器
    int win=0;
    int loss=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c0317_task2);
        init();
    }
    private void init(){
        ImageButton button_scissors = (ImageButton) findViewById(R.id.imageButton_scissors);
        ImageButton button_box = (ImageButton) findViewById(R.id.imageButton_box);
        ImageButton button_hand = (ImageButton) findViewById(R.id.imageButton_hand);
        imageViewphone=(ImageView) findViewById(R.id.imageView_phone);
        textView6=(TextView) findViewById(R.id.textView6);
        button_box.setOnClickListener(this);
        button_hand.setOnClickListener(this);
        button_scissors.setOnClickListener(this);
        button35=(Button) findViewById(R.id.button35);
        button35.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int suiji=(int)(Math.random()*3);//随机数0，1，2，注意，这里的数是Double类型，所以要强制类型转换
        imageViewphone.setImageResource(picture[suiji]);
        //创建对话框
        AlertDialog.Builder builder1= new AlertDialog.Builder(C03_17_task2.this);
        builder1.setTitle("比试结果");
        builder1.setIcon(R.drawable.like);
        builder1.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                  win=0;
                  loss=0;
            }
        });
        switch (view.getId()){
            case R.id.imageButton_box://
                switch (suiji){
                    case 0:textView6.setText("你输了");
                    loss++;
                    break;
                    case 1:textView6.setText("你赢了");
                    win++;
                    break;
                    case 2:textView6.setText("平局");break;
                }
                break;
            case R.id.imageButton_scissors:
                switch (suiji){
                    case 0:textView6.setText("你赢了");
                    win++;
                    break;
                    case 1:textView6.setText("平局");break;
                    case 2:textView6.setText("你输了");
                    loss++;
                    break;
                }
                break;
            case R.id.imageButton_hand:
                switch (suiji){
                    case 0:textView6.setText("平局");break;
                    case 1:textView6.setText("你输了");
                    loss++;
                    break;
                    case 2:textView6.setText("你赢了");
                    win++;
                    break;
                }
                break;
                //这个是button，不用管
            case R.id.button35:
                builder1.setMessage("你赢了"+win+"局"+"\n你输了"+loss+"局");
                AlertDialog alertDialog=builder1.create();
                alertDialog.show();
                break;

        }
    }
}