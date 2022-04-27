package com.example.android_like0302.chapter06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android_like0302.R;

public class C04_39 extends AppCompatActivity implements View.OnClickListener {
    Button button10,button11,button12,button13;
    EditText editText,editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c0439);
        init();
    }
    private void init(){
        button10 =(Button) findViewById(R.id.button10);
        button11 =(Button) findViewById(R.id.button11);
        button12 =(Button) findViewById(R.id.button12);
        button13 =(Button) findViewById(R.id.button13);
        editText=(EditText) findViewById(R.id.editTextTextPersonName);
        editText2=(EditText) findViewById(R.id.editTextTextPersonName2);
        button10.setOnClickListener(this);
        button11.setOnClickListener(this);
        button12.setOnClickListener(this);
        button13.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        //第一步，创建Intent对象
        Intent intent =new Intent();
        //设置Intent对象属性
        Uri uri=null;
        switch (view.getId()){  //新建联系人
            case R.id.button10:
                //调用系统编辑联系人页面，添加该编号联系人
                intent.setAction(Intent.ACTION_INSERT_OR_EDIT);
                //联系人编号为系统由1开始添加
                uri=Uri.parse("content://com.android.contacts/contacts/1");
                break;
            case R.id.button11://获取新建联系人的编号
                 String bianhao =editText.getText().toString().trim();
                 if(TextUtils.isEmpty(bianhao)){
                     Toast.makeText(this,"编号不能为空",Toast.LENGTH_SHORT).show();
                     return;
                 }
                 // 调用系统编辑联系人页面，编辑该联系人
                intent.setAction(Intent.ACTION_EDIT);
                 uri = Uri.parse("content://com.android.contacts/contacts/"+bianhao);
                 break;
            case R.id.button12://查看指定联系人
            //获取输入框中自定义的联系人编号
                String check =editText2.getText().toString().trim();
                if(TextUtils.isEmpty(check)){
                    Toast.makeText(this,"编号不能为空",Toast.LENGTH_SHORT).show();
                    return;
                }
                intent.setAction(Intent.ACTION_VIEW);
                uri=Uri.parse("content://com.android.contacts/contacts/"+check);
                break;
            case R.id.button13://查看所有联系人
                intent.setAction(Intent.ACTION_VIEW);
                uri =Uri.parse("content://contacts/people");
                break;

        }

        intent.setData(uri);
      //利用intent打开组件
        startActivity(intent);

    }
}