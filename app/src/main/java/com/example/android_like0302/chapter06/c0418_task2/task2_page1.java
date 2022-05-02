package com.example.android_like0302.chapter06.c0418_task2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android_like0302.R;

public class task2_page1 extends AppCompatActivity implements View.OnClickListener {
    TextView textViewl;
    Button VIP,huafei,creditCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task2_page1);
        textViewl=findViewById(R.id.textView61);
        VIP=findViewById(R.id.button42);
        huafei=findViewById(R.id.button41);
        creditCard=findViewById(R.id.button43);
        VIP.setOnClickListener(this);
        huafei.setOnClickListener(this);
        creditCard.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent =new Intent(this,task2_page2.class);
        switch (v.getId()){
            case R.id.button41://话费
                startActivityForResult(intent,0);
                break;
            case R.id.button42://会员
                startActivityForResult(intent,1);
                break;
            case R.id.button43://信用卡
                startActivityForResult(intent,2);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 0:
                if (requestCode==0){
                    Toast.makeText(this, "使用支付宝充值话费"+data.getStringExtra("number")+"元", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this, "使用微信充值话费"+data.getStringExtra("number"), Toast.LENGTH_SHORT).show();
                }
                break;
            case 1:
                if (requestCode==0){
                    Toast.makeText(this, "使用支付宝充值会员"+data.getStringExtra("number")+"元", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this, "使用微信充值会员"+data.getStringExtra("number")+"元", Toast.LENGTH_SHORT).show();
                }
                break;
            case 2:
                if (requestCode==0){
                    Toast.makeText(this, "使用支付宝还款"+data.getStringExtra("number")+"元", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this, "使用微信还款"+data.getStringExtra("number")+"元", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}