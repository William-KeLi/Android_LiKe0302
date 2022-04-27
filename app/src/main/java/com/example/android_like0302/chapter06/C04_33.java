package com.example.android_like0302.chapter06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.android_like0302.R;

public class C04_33 extends AppCompatActivity {
    Button button2,button3,button4,button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c0433);
        init();
    }
    private void init(){
        button2=(Button) findViewById(R.id.button2);
        button3=(Button) findViewById(R.id.button3);
        button4=(Button) findViewById(R.id.button4);
        button5=(Button) findViewById(R.id.button5);
        button2.setOnClickListener(new MyListener());
        button3.setOnClickListener(new MyListener());
        button4.setOnClickListener(new MyListener());
        button5.setOnClickListener(new MyListener());
    }
class MyListener implements View.OnClickListener{
    @Override
    public void onClick(View view) {
        Intent intent =new Intent();
        switch (view.getId()){
            case R.id.button2:
                intent.setAction(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_APP_BROWSER);
                startActivity(intent);
                break;
            case R.id.button3:
                intent.setAction(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_APP_MESSAGING);
                startActivity(intent);
                break;
            case R.id.button4:
                intent.setAction(Intent.ACTION_DIAL);
                startActivity(intent);
                break;
            case R.id.button5:
                intent.setAction(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_APP_CONTACTS);
                startActivity(intent);
                break;
        }
    }
}
}