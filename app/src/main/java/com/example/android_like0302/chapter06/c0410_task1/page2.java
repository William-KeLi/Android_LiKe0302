package com.example.android_like0302.chapter06.c0410_task1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.android_like0302.R;

public class page2 extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);
        textView=findViewById(R.id.textView57);
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        textView.setText(bundle.getString("result"));
    }
}