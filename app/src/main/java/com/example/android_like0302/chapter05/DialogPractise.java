package com.example.android_like0302.chapter05;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.android_like0302.R;

public class DialogPractise extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_practise);
        button=(Button)findViewById(R.id.button_dialogtext);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //1.创建AlertBuilder对象
                AlertDialog.Builder builder = new AlertDialog.Builder(DialogPractise.this);
                //2.设置对话框标题
                builder.setTitle("仅用于测试");
                //3.设置对话框图标
                builder.setIcon(R.drawable.t301_chicken);
                //4.设置对话框内容
                builder.setMessage("成年人创建的第一次对话框");
                //5.设置对话框确认按钮
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(DialogPractise.this, "点击了确认", Toast.LENGTH_SHORT).show();
                    }
                });
                //6.设置对话框否认按钮
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(DialogPractise.this, "你点击了取消", Toast.LENGTH_SHORT).show();
                    }
                });
                //7.根据builder来创建AlertDialog对象
                AlertDialog dialog =builder.create();
                //8.将3dialog展示出来
                dialog.show();
            }
        });
    }
}