package com.example.android_like0302.chapter05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.android_like0302.R;

import java.util.regex.Pattern;

public class C03_25_task3 extends AppCompatActivity {
    //1.定义相关控件
    EditText etusername,etbirth,etemail;
    RadioGroup radioGroup;
    CheckBox boxgame,boxbaskball,boxyumao;
    Button button;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c0325_task3);
        init();//2.控件初始化
        //3.给单选按钮设置监听器
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i==R.id.radioboy){//如果点击的是“男”按钮
                    Toast.makeText(C03_25_task3.this, "选择：男", Toast.LENGTH_SHORT).show();
                }else {//否则
                    Toast.makeText(C03_25_task3.this, "选择：女", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //4.给Edittext设置键盘监听器
        //当用户对于文本输入框输入文本时，就会触发键盘事件监听器
        etemail.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view,int i, KeyEvent keyEvent) {
                //定义一个字符串，用来接收邮箱的输入
                String email ="";
                if (keyEvent.getAction()==KeyEvent.ACTION_UP) {//当键盘抬起的时候
                    email=etemail.getText().toString();
                    String regex ="^[0-9A-Za-z]+@[a-zA-Z.]*(com|cn)";//用正则表达式来表示
                    if(Pattern.matches(regex,email)){//如果符合格式，就显示对
                        imageView.setImageResource(R.drawable.t303_right);
                    }else {//否则，就显示错
                        imageView.setImageResource(R.drawable.t303_wrong);
                    }
                }
                //返回false1意味着时间可以继续扩散，意思就是edittext可以得知用户的输入
                //如果返回true，则不可以得知输入
                return false;
            }
        }) ;
        //给按钮设置一个单击事件监听器
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //定义一个字符串，用于存放复选框的结果
                String str="";
                if (boxgame.isChecked()==true){
                    str+="游戏";
                }
                if (boxyumao.isChecked()==true){
                    str+="羽毛球";
                }
                if (boxbaskball.isChecked()==true){
                    str+="篮球";
                }
                Toast.makeText(C03_25_task3.this, str, Toast.LENGTH_SHORT).show();
            }
        });

    }
    private void init(){
        etbirth=(EditText) findViewById(R.id.et_birthdate);
        etusername=(EditText) findViewById(R.id.et_uesrname);
        etemail=(EditText) findViewById(R.id.et_email);
        radioGroup=(RadioGroup) findViewById(R.id.rgsex);
        boxbaskball=(CheckBox) findViewById(R.id.checkBoxbasketball);
        boxgame=(CheckBox) findViewById(R.id.checkBoxgame);
        boxyumao=(CheckBox) findViewById(R.id.checkBoxyumao);
        button=(Button) findViewById(R.id.button_xinxitijiao);
        imageView=(ImageView) findViewById(R.id.panduan);
    }
}