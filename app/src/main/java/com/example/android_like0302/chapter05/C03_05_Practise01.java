package com.example.android_like0302.chapter05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.android_like0302.R;

public class C03_05_Practise01 extends AppCompatActivity {
   Button button;
     int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c0305_practise01);
        button=(Button) findViewById(R.id.button_practise01);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId()==R.id.button_practise01){
                    count++;
                    button.setText("我被点击了"+count+"次");
                }
            }
        });
    }
}