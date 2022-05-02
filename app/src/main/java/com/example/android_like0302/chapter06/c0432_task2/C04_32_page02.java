package com.example.android_like0302.chapter06.c0432_task2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.android_like0302.R;

public class C04_32_page02 extends AppCompatActivity {
    TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c0432_page02);
        init();
    }
    private void init(){
        textView1 =(TextView)findViewById(R.id.textView);
        Intent intent =getIntent();
        String action = intent.getAction();
        textView1.setText(action);
    }
}