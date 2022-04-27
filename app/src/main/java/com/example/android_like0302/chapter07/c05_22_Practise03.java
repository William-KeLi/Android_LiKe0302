package com.example.android_like0302.chapter07;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.android_like0302.R;

import java.io.File;

public class c05_22_Practise03 extends AppCompatActivity implements View.OnClickListener {
 Button button25;
 LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c0522_practise03);
        init();
    }
    private void init(){
        button25=(Button) findViewById(R.id.button25);
        linearLayout=(LinearLayout) findViewById(R.id.line);
        button25.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.button25) {
            //检测是否存在SD卡
            String result = Environment.getExternalStorageState();
            if (result.equals(Environment.MEDIA_MOUNTED)) {//如果存在，九江各个文件显示出来
                File f1 = Environment.getExternalStorageDirectory();//获取SD卡的目录
                File[] f2 =f1.listFiles();//将目录都存放在数组中
                for (int i = 0; i < f2.length ; i++) {
                    TextView tv = new TextView(this);//创建TextView
                    tv.setText(f2[i].getAbsolutePath());//将目录的路径打在公屏上
                    linearLayout.addView(tv);//将textView添加控件
                }

            }else {//不存在，就提示
                TextView tv = new TextView(this);//创建TextView
                tv.setText("SD卡不存在");//将目录的路径打在公屏上
                linearLayout.addView(tv);//将textView添加控件
            }
        }
    }
}