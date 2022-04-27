package com.example.android_like0302.chapter07;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.widget.EditText;

import com.example.android_like0302.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class C05_14 extends AppCompatActivity {
   EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c0514);
        //按照步骤来
        //1.首先，获得判断是否有sd卡，并且是否支持读写
        String result = Environment.getExternalStorageState();
        //2.根据返回值结果来判断，如果有SD卡并且可以读写，那么就进行存储，否则结束
        if (result.equals(Environment.MEDIA_MOUNTED)) {
            //3.获取sd卡“文件”分类目录
            File f1=getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
            //4.创建读取的File对象
            File f2 = new File(f1.getAbsolutePath(),"hard.txt");
            //5.创建文件输出流
            try {
                FileOutputStream fo1= new FileOutputStream(f2);
                //6.写入文件
                String content ="Hello Death";
                byte[] bytes =content.getBytes();
                fo1.write(bytes);
                //7.关闭输出流
                fo1.flush();
                fo1.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            return;
        }


    }
}