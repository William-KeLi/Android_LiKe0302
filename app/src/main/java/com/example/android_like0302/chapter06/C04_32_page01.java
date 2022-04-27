package com.example.android_like0302.chapter06;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.android_like0302.R;

public class C04_32_page01 extends AppCompatActivity {
   Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c0432_page01);
        init();
    }
    private void init(){
        button1 =(Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(C04_32_page01.this,C04_32_page02.class);
                intent.setAction("LIKE");
                startActivity(intent);
            }
        });
    }


}