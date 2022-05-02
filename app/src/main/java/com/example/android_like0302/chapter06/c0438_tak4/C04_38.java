package com.example.android_like0302.chapter06.c0438_tak4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.android_like0302.R;

public class C04_38 extends AppCompatActivity {
    Button button6,button7,button8,button9;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c0438);
        init();
    }
    private void init(){
        button6=(Button) findViewById(R.id.button6);
        button7=(Button) findViewById(R.id.button7);
        button8=(Button) findViewById(R.id.button8);
        button9=(Button) findViewById(R.id.button9);
        button6.setOnClickListener(new MyListener());
        button7.setOnClickListener(new MyListener());
        button8.setOnClickListener(new MyListener());
        button9.setOnClickListener(new MyListener());
    }
    class MyListener implements View.OnClickListener{
        Intent intent =new Intent();
        @Override
        public void onClick(View view) {
            Intent intent =new Intent();
            switch (view.getId()){
                case R.id.button6://浏览百度网页
                    //设置intent的各种属性
                    //ACTION Data
                    intent.setAction(Intent.ACTION_VIEW);
                    //对于data数据，需要给一个uri对象
                    Uri uri =Uri.parse("http://www.baidu.com");
                    intent.setData(uri);
                    break;
                case R.id.button7:   //选择图片
                    intent.setAction(Intent.ACTION_PICK);
                    intent.setType("image/*");
                    break;
                case R.id.button8:   //拨打电话
                    intent.setAction(Intent.ACTION_CALL);
                    Uri uri1 = Uri.parse("tel:17852368325");
                    intent.setData(uri1);


                    break;
                case R.id.button9:
                    intent.setAction(Intent.ACTION_SENDTO);
                    Uri uri2 =Uri.parse("smsto:17852368325");
                    intent.setData(uri2);
                    intent.putExtra("sms_name","Hello World");

                    break;
            }
            startActivity(intent);
        }
    }
}