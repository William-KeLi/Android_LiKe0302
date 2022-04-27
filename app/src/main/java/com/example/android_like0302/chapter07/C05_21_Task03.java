package com.example.android_like0302.chapter07;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android_like0302.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class C05_21_Task03 extends AppCompatActivity implements View.OnClickListener{
    EditText editText;
    Button buttonstore,buttonflash,buttonread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c0521_task03);
        init();
    }
    private void init(){
        editText=(EditText) findViewById(R.id.editTextTextMultiLine);
        buttonflash=(Button) findViewById(R.id.button23);
        buttonread=(Button) findViewById(R.id.button24);
        buttonstore=(Button) findViewById(R.id.button22);
        buttonstore.setOnClickListener(this);
        buttonread.setOnClickListener(this);
        buttonflash.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //1.获得SD卡分类的目录
        File f1 =getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
        //2.创建读取的File对象
        File f2 = new File(f1.getAbsolutePath(),"night214.txt");
        //3.根据不同的按钮，设定不同的功能
        switch (v.getId()){
            case R.id.button22://存储
                //首先获取SD卡的状态，主要是状态，因为我们已经知道有SD卡了
                String condition = Environment.getExternalStorageState();
                if (condition.equals(Environment.MEDIA_MOUNTED)) {//如果是可读写的状态，则将内容跟存放进去
                    try {
                        FileOutputStream f3 = new FileOutputStream(f2);//创建输出流
                        f3.write(editText.getText().toString().trim().getBytes());//写文件
                        f3.flush();//关闭流
                        f3.close();
                        Toast.makeText(this, "保存成功", Toast.LENGTH_SHORT).show();//提示
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else {
                    Toast.makeText(this, "文件不可修改！", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.button23://刷新
                editText.setText("");//将文本设置为空即可实现刷新
                break;
            case R.id.button24://读取
                try {
                    FileInputStream f4 = new FileInputStream(f2);//创建流
                    byte[] bytes=new byte[1024];//创建缓冲区
                    f4.read(bytes);//读取数据
                    String str = new String(bytes);
                    editText.setText(str+"\n"+"文件地址"+f2.getAbsolutePath());
                    f4.close();//关闭流
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}