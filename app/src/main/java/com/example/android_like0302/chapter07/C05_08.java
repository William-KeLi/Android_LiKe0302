package com.example.android_like0302.chapter07;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.example.android_like0302.R;

public class C05_08 extends AppCompatActivity {
    TextView textView14;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c0508);
        init();
        SharedPreferences s1=getSharedPreferences("count",MODE_PRIVATE);
        int count =s1.getInt("count",0);
        count++;

        textView14.setText("我被打开了"+count+"次");

        SharedPreferences.Editor editor=s1.edit();
        editor.putInt("count",count);
        editor.commit();
    }
    private void init(){
        textView14=(TextView) findViewById(R.id.textView14);
    }
}