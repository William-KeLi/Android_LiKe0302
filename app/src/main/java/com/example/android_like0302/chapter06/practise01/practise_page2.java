package com.example.android_like0302.chapter06.practise01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.android_like0302.R;

public class practise_page2 extends AppCompatActivity implements View.OnClickListener {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practise_page2);
        button=findViewById(R.id.button40);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent=getIntent();
        setResult(1,intent);
        finish();

    }
}