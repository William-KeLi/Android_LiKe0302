package com.example.android_like0302.chapter07;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android_like0302.R;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class C05_16_Task02 extends AppCompatActivity implements View.OnClickListener {
    Button buttonStore,buttonFlash,buttonRead;
    EditText data,content;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c0516_task02);
       init();
    }
    private void init(){
        buttonFlash=(Button) findViewById(R.id.button27);
        buttonRead=(Button) findViewById(R.id.button28);
        buttonStore=(Button) findViewById(R.id.button26);
        data=(EditText) findViewById(R.id.editTextDate);
        content=(EditText) findViewById(R.id.editTextTextMultiLine2);
        buttonStore.setOnClickListener(this);
        buttonRead.setOnClickListener(this);
        buttonFlash.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
          switch (v.getId()){
              case R.id.button26://存储
                  //首先判断日期是否写了（这里没有眼科看是否是日期的正确格式，只要是数字就行）
                  if (data.getText().toString().trim().isEmpty()){//如果没写，就提示
                      Toast.makeText(this, "请输入日期", Toast.LENGTH_SHORT).show();
                      return;
                  }else{//如果写了，就去判断内容是否为空
                      if (content.getText().toString().trim().isEmpty()){//如果为空也进行提示
                          content.setText("请输入内容！");
                          return;
                      }else{//如果有内容，那么就存储
                          //创建文件输出流，并存放在单独的一个一日起为名字的文件
                          try {
                              FileOutputStream f1 = openFileOutput(data.getText().toString().trim(),MODE_PRIVATE);
                              //将日记内容转化为byte，并传入byte数组
                              byte[] bytes=content.getText().toString().trim().getBytes();
                              //将内容传入文件
                              f1.write(bytes);
                              //刷新流
                              f1.flush();
                              //提示：存储成功
                              Toast.makeText(this, "存储成功", Toast.LENGTH_SHORT).show();
                              //关闭流
                              f1.close();
                          } catch (Exception e) {
                              e.printStackTrace();
                          }
                      }
                  }
                  break;
              case R.id.button27://刷新
                  data.setText("");
                  content.setText("");
                  break;
              case R.id.button28://读取
                  //从android创建文件输入流
                  if (data.getText().toString().trim().isEmpty()){
                      Toast.makeText(this, "请输入日期", Toast.LENGTH_SHORT).show();
                      return;
                  }
                  try {
                      FileInputStream f2 = openFileInput(data.getText().toString().trim());
                      //创建BYTE数组作为缓冲区
                      byte [] Bytes =new byte[1024];
                      //将数据存入缓冲流
                      f2.read(Bytes);
                      //将数据从输入流打印到文本
                      content.setText(new String(Bytes));
                      //关闭输入流
                      f2.close();
                  } catch (Exception e) {
                      e.printStackTrace();
                  }
                  break;
          }
    }
}