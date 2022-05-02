package com.example.android_like0302.chapter06.c0410_task1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.android_like0302.R;

public class page1 extends AppCompatActivity implements View.OnClickListener {
    EditText username,password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);
        init();
    }
    private void init(){
        username=findViewById(R.id.editTextTextPersonName11);
        password=findViewById(R.id.editTextTextPassword6);
        login=findViewById(R.id.button38);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String name=username.getText().toString().trim();
        String word=password.getText().toString().trim();
        Intent intent=new Intent(this,page2.class);
        Bundle bundle=new Bundle();
        if (name.equals("admin")&&word.equals("admin")){
         bundle.putString("result","登陆成功，欢迎admin!");
        }else {
            bundle.putString("result","登陆失败！");
        }
        intent.putExtras(bundle);
        startActivity(intent);
    }
}