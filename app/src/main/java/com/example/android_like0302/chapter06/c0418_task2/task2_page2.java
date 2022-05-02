package com.example.android_like0302.chapter06.c0418_task2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.android_like0302.R;

public class task2_page2 extends AppCompatActivity implements View.OnClickListener {
    EditText editText;
    Button Alipay,wxpay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task2_page2);
        editText=findViewById(R.id.editTextNumber);
        Alipay=findViewById(R.id.button44);
        wxpay=findViewById(R.id.button45);
        Alipay.setOnClickListener(this);
        wxpay.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent=getIntent();
        switch (v.getId()){
            case R.id.button44://支付宝支付
                String num = editText.getText().toString().trim();
                intent.putExtra("number",num);
                setResult(0,intent);
                finish();
                break;
            case R.id.button45://微信支付
                String num1 = editText.getText().toString().trim();
                intent.putExtra("number",num1);
                setResult(1,intent);
                finish();
                break;
        }
    }
}