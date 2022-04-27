package com.example.android_like0302.diancai;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.android_like0302.R;

public class SecondTask extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {
    CheckBox yu,tudousi,chang,qiezi;
    RadioGroup group;
    Button button;
    RadioButton yes,no;
    String str = "您点的菜为：";
    String dabao="并且";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_task);
        init();
    }

    private void init() {
        yu = findViewById(R.id.yu);
        tudousi = findViewById(R.id.tudousi);
        chang = findViewById(R.id.chang);
        qiezi = findViewById(R.id.qiezi);
        group = findViewById(R.id.dabao);
        button = findViewById(R.id.button37);
        yes = findViewById(R.id.radioButton_yes);
        no = findViewById(R.id.radioButton_no);
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                  if (checkedId == R.id.radioButton_yes) {
                      dabao += "打包";
                      yes.setChecked(true);
                  } else if (checkedId == R.id.radioButton_no) {
                      dabao += "不打包";
                      no.setChecked(true);
                  }
            }
        });
        yu.setOnCheckedChangeListener(this);
        tudousi.setOnCheckedChangeListener(this);
        chang.setOnCheckedChangeListener(this);
        qiezi.setOnCheckedChangeListener(this);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
    if (v.getId()==R.id.button37){

        Toast.makeText(this, str+dabao, Toast.LENGTH_SHORT).show();
    }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

       switch (buttonView.getId()){
           case R.id.yu:
               if (isChecked){
                   str += "糖醋鲤鱼，";
               }else {
                   if (str.contains("糖醋鲤鱼，")) {
                       str = str.replace("糖醋鲤鱼，", "");
                   }
               }
               break;
           case R.id.tudousi:
               if (isChecked){
                   str += "酸辣土豆丝，";
               }else {
                   if (str.contains("酸辣土豆丝，")) {
                       str = str.replace("酸辣土豆丝，", "");
                   }
               }
               break;
           case R.id.chang:
               if (isChecked){
                   str += "九转大肠，";
               }else {
                   if (str.contains("九转大肠，")) {
                       str = str.replace("九转大肠，", "");
                   }
               }
               break;
           case R.id.qiezi:
               if (isChecked){
                   str += "红烧茄子，";
               }
               else {
                   if (str.contains("红烧茄子，")) {
                       str = str.replace("红烧茄子，", "");
                   }
               }
               break;
       }
    }
}