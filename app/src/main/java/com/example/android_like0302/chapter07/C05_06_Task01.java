package com.example.android_like0302.chapter07;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android_like0302.R;

public class C05_06_Task01 extends AppCompatActivity implements View.OnClickListener {
    EditText username2;
    Button buttonduqu,buttoncunchu,buttonshuaxin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c0506_task01);
        init();
  }
    private void init(){
//        username2=(EditText) findViewById(R.id.et_uesrname2);
//        buttoncunchu=(Button) findViewById(R.id.buttoncunchu);
//        buttonduqu=(Button) findViewById(R.id.buttonduqu);
//        buttonshuaxin=(Button) findViewById(R.id.buttonshuaxin);
//        buttonshuaxin.setOnClickListener(this);
//        buttonduqu.setOnClickListener(this);
//        buttoncunchu.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //创建SharedPreferences对象，存储数据
        SharedPreferences s1 =getSharedPreferences("C05_06_Task01",MODE_PRIVATE);
        switch (v.getId()){
            case R.id.buttoncunchu:
                String name=username2.getText().toString().trim();
                if (name.isEmpty()) {
                    Toast.makeText(this,"名字不能为空",Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    SharedPreferences.Editor editor= s1.edit();
                    editor.putString("name",name);
                    editor.commit();
                    Toast.makeText(this, "数据存储成功", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.buttonshuaxin:
                username2.setText("");
                break;
            case R.id.buttonduqu:
                String quname=s1.getString("name","未设置");
                username2.setText(quname);

                break;
        }
    }
}